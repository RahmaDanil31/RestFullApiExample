package app.Rest.RestFullApiExample.Helper.Mapper;

import org.modelmapper.ModelMapper;

public class ObjectHelper {

    // for copy dto to entity or otherwise
    public static <T> T convert(Object source, Class<T> destinationType) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }
}
