//package com.andreahowes.dive_db.data.dives;
//
//import com.andreahowes.dive_db.logic.dive.Dive;
//import javafx.application.Application;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class GenericEntityRepositoryTest {
//
//    @Autowired
//    private GenericEntityRepository genericEntityRepository;
//
//    @Test
//    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK(){
//        Dive createdDive = genericEntityRepository.save(new Dive());
//        Dive foundDive = genericEntityRepository.findOne(createdDive.getId());
//
//        assertNotNull(foundDive);
//        assertEquals(createdDive.getId(), foundDive.getId());
//
//    }
//
//
//}