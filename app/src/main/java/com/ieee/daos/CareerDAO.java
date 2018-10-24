package com.ieee.daos;

import com.ieee.entity.Career;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface CareerDAO {

    void registerCareer(Career career);

    ArrayList<Career> listCareer();

    Career consultCareer(int id_career);

    void updateCareer(Career career);

    void removeCareer(int id_career);

}
