package com.songmag.tiny.service.userService.dto;

import java.util.List;

public class UserRepository extends ImplRepository implements Repsitory<UserRepository,DataObject>{


    @Override
    public UserRepository get() {

        return null;
    }

    @Override
    public UserRepository get(DataObject object) {

        return null;
    }

    @Override
    public List<UserRepository> findAll(DataObject object) {

        return null;
    }

    @Override
    public List<UserRepository> findAllWithLimit(DataObject object, long offset, long limit) {

        return null;
    }

    @Override
    public long insert(List<DataObject> objects) {

        return 0;
    }

    @Override
    public long update(List<DataObject> objects) {

        return 0;
    }
}
