package com.group2.filterism.template.application;

import com.group2.filterism.template.presentation.TemplateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface CreateTemplateUseCase {
    String execute(TemplateForm form);
}

@Service
@RequiredArgsConstructor
class CreateTemplateUseCaseImpl implements CreateTemplateUseCase {

    @Override
    public String execute(TemplateForm form) {

        return "";
    }
}
