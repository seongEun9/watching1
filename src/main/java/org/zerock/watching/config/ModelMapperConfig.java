package org.zerock.watching.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//  DTO와 엔티티 간의 자동 매핑
@Configuration
public class ModelMapperConfig {

    @Bean // --->  ModelMapper를 Spring bean으로 설정
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper(); // --->  modelMapper 객체 생성

        modelMapper.getConfiguration() // ---> 환경설정
                .setFieldMatchingEnabled(true) // ---> 필드 매칭 활성화
                .setFieldAccessLevel(org.modelmapper.config.Configuration
                        .AccessLevel.PRIVATE); // ---> private 필드에도 접근 가능하도록 설정

        return modelMapper;
    }
}