package com.example.pokedex.dataRepository.entitites;

import java.util.List;

public class EncounterDetail
{
    public int chance ;
    public List<ConditionValue> condition_values ;
    public int max_level ;
    public Method method ;
    public int min_level ;

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public List<ConditionValue> getCondition_values() {
        return condition_values;
    }

    public void setCondition_values(List<ConditionValue> condition_values) {
        this.condition_values = condition_values;
    }

    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public int getMin_level() {
        return min_level;
    }

    public void setMin_level(int min_level) {
        this.min_level = min_level;
    }
}

