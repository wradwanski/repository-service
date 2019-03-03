package com.wradwanski.repository.controller;

import com.wradwanski.repository.client.GithubClient;
import com.wradwanski.repository.client.GithubClient.RepositoryDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryControllerTest {

    @Mock
    private GithubClient githubClient;

    @InjectMocks
    private RepositoryController repositoryController;

    @Test
    public void shouldReturnValidRepositoryDetails() {
        //given
        String owner = "owner";
        String repository = "repository";

        RepositoryDetails repositoryDetails = RepositoryDetails.builder()
                .cloneUrl("cloneUrl").createdAt("createdAt")
                .fullName("repositoryName").stars(10L).build();

        when(githubClient.findByOwnerAndRepo(eq(owner), eq(repository))).thenReturn(repositoryDetails);

        //when
        RepositoryDetails byOwnerAndRepositoryName = repositoryController
                .findByOwnerAndRepositoryName(owner, repository);

        //then
        assertThat(byOwnerAndRepositoryName).isEqualTo(repositoryDetails);

    }

}