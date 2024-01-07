package be.sertifikasi.isb.list.service;

import be.sertifikasi.isb.list.model.ListRequest;
import be.sertifikasi.isb.list.model.ListResponse;
import be.sertifikasi.isb.list.repository.List;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "book", source = "book")
    ListResponse toResponse(List list);

    List fromRequest(ListRequest listRequest);

    void updateListFromRequest(@MappingTarget List list, ListRequest listRequest);
}
