package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.Helper.Util.ResponseItem;
import app.Rest.RestFullApiExample.MasterData.Controller.CategoryController;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.Filter.CategoryDtoFilter;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService implements ServiceImpl<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseItem get(CategoryDtoFilter filter){

        int count = categoryRepository.count(filter);
        ResponseItem responseItem = new ResponseItem();

        responseItem.setMeta(ResponseItem.Meta.builder()
                .totalItems(count)
                .currentPage(filter.getCurrentPage())
                .itemsPerPage(filter.getItemsPerPage())
                .totalPages((int) Math.ceil((float) count / filter.getItemsPerPage()))
                .build());

        List<CategoryDto> categoryDtos = ObjectHelper.convertList(categoryRepository.view(filter,filter.buildPage(false)), CategoryDto.class);

        responseItem.setItems(categoryDtos);

        return responseItem;
    }

    @Override
    public CategoryDto saveOrUpdate(CategoryDto dto) {
        Category category = ObjectHelper.convert(dto,Category.class);
        return ObjectHelper.convert(categoryRepository.save(category),CategoryDto.class);
    }

    @Override
    public CategoryDto loadById(Long id){
        return ObjectHelper.convert(
                categoryRepository.findById(id)
                .orElseThrow(()-> new NoDataFoundException()),CategoryDto.class);
    }

    @Override
    public void delete(Long id) {
        CategoryDto categoryDto = loadById(id);
        categoryRepository.deleteById(categoryDto.getId());
    }

}
