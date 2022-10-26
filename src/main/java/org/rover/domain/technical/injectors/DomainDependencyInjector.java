package org.rover.domain.technical.injectors;

import org.rover.domain.api.PositionsProvider;
import org.rover.domain.api.PositionsProviderImpl;
import org.rover.domain.services.evaluation.plateau.create.PlateauCreator;
import org.rover.domain.services.evaluation.position.evaluate.PositionEvaluator;
import org.rover.domain.services.evaluation.position.init.PositionInitializer;

public class DomainDependencyInjector {

    public static Object getInstance(Object object){
        Object instance = null;
        if(object == PositionsProvider.class){
            instance = new PositionsProviderImpl(
                    new PlateauCreator(),
                    new PositionInitializer(),
                    new PositionEvaluator()
            );
        }
        return instance;
    }
}
