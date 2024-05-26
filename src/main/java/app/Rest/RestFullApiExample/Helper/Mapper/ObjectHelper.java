package app.Rest.RestFullApiExample.Helper.Mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class ObjectHelper {

    // for copy dto to entity or otherwise
    public static <T> T convert(Object source, Class<T> destinationType) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }

    public static <S, T> List<T> convertList(List<S> source, Class<T> targetClass) {
        ModelMapper modelMapper = new ModelMapper();

        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
