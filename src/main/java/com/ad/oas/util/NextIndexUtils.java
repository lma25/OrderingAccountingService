package com.ad.oas.util;

import com.ad.oas.exception.DataParsingException;
import com.ad.oas.exception.InvalidDataException;
import com.ad.oas.model.NextIndex;
import com.ad.oas.repository.NextIndexRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class NextIndexUtils {

    @Autowired
    private NextIndexRepository nextIndexRepository;

    @Resource(name="objectMapper")
    private ObjectMapper objectMapper;

    public Long getNextIndex(@NonNull final String key){
        final List<NextIndex> nextIndexs = nextIndexRepository.findAll();

        /**
         * If there is no nextIndex, initialize nextIndex.
         */
        if(nextIndexs.isEmpty()){
            nextIndexs.add(initializeNextIndex());
        }

        /**
         * Get the next index for key.
         */
        final Map<String, Long> nextIndexMap = objectMapper.convertValue(nextIndexs.get(0), Map.class);
        if(!nextIndexMap.containsKey(key)){
            throw new InvalidDataException("nextIndexMap doesn't contain key " + key);
        }
        Long next = nextIndexMap.get(key);

        /**
         * Update table with new index.
         */
        nextIndexMap.put(key, next + 1);
        NextIndex newNextIndex = null;
        try {
            newNextIndex = objectMapper.readValue(objectMapper.writeValueAsString(nextIndexMap), NextIndex.class);
        } catch (IOException e) {
            throw new DataParsingException("nextIndexMap cannot be parsed successfully.");
        }
        nextIndexRepository.save(newNextIndex);

        return next;
    }

    private NextIndex initializeNextIndex(){
        final NextIndex nextIndex = new NextIndex((long)1, (long)1, (long)1, (long)1, (long)1);
        nextIndexRepository.save(nextIndex);
        return nextIndex;
    }



}
