package org.rover.infra.repositories;

import org.rover.domain.services.PositionRepository;

public class DisplayPositionRepository implements PositionRepository {

    @Override
    public void show(String result) {
        System.out.print(result);
    }
}
