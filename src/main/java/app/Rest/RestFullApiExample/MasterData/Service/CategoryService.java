package app.Rest.RestFullApiExample.MasterData.Service;

import app.Rest.RestFullApiExample.Helper.Exception.NoDataFoundException;
import app.Rest.RestFullApiExample.Helper.Implement.ServiceImpl;
import app.Rest.RestFullApiExample.Helper.Mapper.ObjectHelper;
import app.Rest.RestFullApiExample.MasterData.DTO.CategoryDto;
import app.Rest.RestFullApiExample.MasterData.Model.Category;
import app.Rest.RestFullApiExample.MasterData.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements ServiceImpl<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
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
    public CategoryDto loadByUUID(UUID uuid) {
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteByUUID(UUID uuid) {

    }
}
