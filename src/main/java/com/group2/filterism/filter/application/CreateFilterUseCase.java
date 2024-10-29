package com.group2.filterism.filter.application;

import com.group2.filterism.filter.domain.FilterDomainDto;
import org.springframework.stereotype.Service;

public interface CreateFilterUseCase {
    String execute(FilterDomainDto dto);
}

@Service
class CreateFilterUseCaseImpl implements CreateFilterUseCase {

    @Override
    public String execute(FilterDomainDto dto) {

        return "";
    }
}
