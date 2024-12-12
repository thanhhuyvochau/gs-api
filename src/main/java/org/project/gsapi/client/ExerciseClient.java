package org.project.gsapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.project.gsapi.entity.Exercise;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class ExerciseClient {
    private final String BASE_URL = "https://api.api-ninjas.com/v1/exercises";
    private final RestTemplate restTemplate;

    public ExerciseClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Exercise> getExerciseByMuscle(String muscle) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", "yeK09bIYWlV+ibZDjngSXg==zsQnOM31MuvO0Ks2");

        String url = UriComponentsBuilder
                .fromHttpUrl(BASE_URL)
                .queryParam("muscle", muscle)
                .toUriString();

        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        ResponseEntity<List<Exercise>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<Exercise>>() {
                }
        );

        return response.getBody();
    }

}
