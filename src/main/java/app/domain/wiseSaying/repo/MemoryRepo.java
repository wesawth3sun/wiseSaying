package app.domain.wiseSaying.repo;

import app.domain.wiseSaying.WiseSaying;
import app.standard.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static app.standard.Util.*;

public class MemoryRepo implements Repository{
    //데이터베이스와의 직접적인 상호 작용
    //CRUD(Create, Read, Update, Delete) 작업 수행
    //저장소의 역할


    private int lastNo;
    private final List<WiseSaying> list;

    public MemoryRepo() {
        this.list = new ArrayList<>();
        lastNo = 1;
        System.out.println("메모리 DB 사용");
    }

    public WiseSaying save(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(lastNo, content, author);
        list.add(wiseSaying);
        lastNo++;
        return wiseSaying;
    }

    public List<WiseSaying> getList() {
        return list;
    }

    @Override
    public Optional<WiseSaying> findById(int id) {
        return Optional.empty();
    }


    public void delete(WiseSaying wiseSaying) {
        list.remove(wiseSaying);
    }

    public WiseSaying getId(int id) {
        for (WiseSaying wiseSaying : list) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int i) {

    }

    @Override
    public void build() {
    }

    @Override
    public String getBuildPath() {
        return "";
    }
}
