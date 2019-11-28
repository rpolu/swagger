package com.maruf.kalah.repository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bol.kalaha.assignment.api.model.Game;
import com.bol.kalaha.assignment.api.repository.GameMemoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameMemoryRepositoryTest {

    @Autowired
    private GameMemoryRepository  gameMemoryRepository;

    @Test
    public void shouldCreateGame(){

        //given
        Game game1 = gameMemoryRepository.create(6);

        //when
        Game game = gameMemoryRepository.findById(game1.getId());

        //assert
        Assert.assertNotNull(game);
        Assert.assertEquals(game1, game1);
    }
}
