package com.spring.university.backenduniversity;

import com.spring.university.backenduniversity.dao.ClassRoomDAO;
import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClassRoomCommands implements CommandLineRunner {
    private final ClassRoomDAO classRoomService;

    public ClassRoomCommands(ClassRoomDAO classRoomService) {
        this.classRoomService = classRoomService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*ClassRoom myClassRoom = new ClassRoom(null, 1, "40x40", 30, Board.WHITEBOARD);
        ClassRoom myClassRoom2 = new ClassRoom(null, 2, "50x50", 40, Board.BLACKBOARD);
        ClassRoom myClassRoom3 = new ClassRoom(null, 3, "20x20", 15, Board.WHITEBOARD);
        ClassRoom myClassRoom4 = new ClassRoom(null, 4, "60x60", 35, Board.BLACKBOARD);
        ClassRoom myClassRoom5 = new ClassRoom(null, 5, "70x70", 55, Board.WHITEBOARD);

        this.classRoomService.save(myClassRoom);
        this.classRoomService.save(myClassRoom2);
        this.classRoomService.save(myClassRoom3);
        this.classRoomService.save(myClassRoom4);
        this.classRoomService.save(myClassRoom5);
        Optional<ClassRoom> room = this.classRoomService.findByRoomNumber(2);
        room.ifPresent(System.out::println);
        */
    }
}
