package ru.danilov.raceapi.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.danilov.raceapi.dto.StepDataDTO;
import ru.danilov.raceapi.models.StepData;

@Component
public class ModelMapperUtil {

    private final ModelMapper modelMapper;

    @Autowired
    public ModelMapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StepData convertToStepData(StepDataDTO stepDataDTO) {
        return this.modelMapper.map(stepDataDTO, StepData.class);
    }
}
