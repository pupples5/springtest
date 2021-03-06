package com.example.demo.service;


import com.example.demo.model.Executive;
import com.example.demo.model.ExecutiveResponseDto;
import com.example.demo.model.ExecutiveState;
import com.example.demo.model.ExecutiveUpdateRequestDto;
import com.example.demo.repository.ExecutiveRepository;
import com.example.demo.repository.ExecutiveStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;
    private final ExecutiveStateRepository executiveStateRepository;

    public ArrayList<ExecutiveResponseDto> getAll() {

        List<Executive> all = executiveRepository.findAll();

        Iterator<Executive> it = all.iterator();
        ArrayList<ExecutiveResponseDto> list = new ArrayList<>();
        while (it.hasNext()) {
            Executive ex = it.next();

            list.add(new ExecutiveResponseDto(ex));
        }

        return list;
    }

    public ExecutiveResponseDto findByexecutiveId(String executiveId) {

        System.out.println(executiveId);
        Executive ex = executiveRepository.findByExecutiveId(executiveId);
        System.out.println(ex.toString());
        return new ExecutiveResponseDto(ex);
    }


    public List<ExecutiveState> getAllexecutiveState() {

        System.out.println(executiveStateRepository.findAll().get(0).getExecutiveState());
        return executiveStateRepository.findAll();
    }

    @Transactional
    public Long update(String executiveId, ExecutiveUpdateRequestDto requestDto) {

        Executive exec = executiveRepository.findByExecutiveId(executiveId);
        System.out.println(exec.toString());
        exec.update(requestDto.getState(), requestDto.getDescription());
        System.out.println(exec.toString());
        return exec.getExecutiveNo();

    }


}
