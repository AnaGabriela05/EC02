package com.anagabriela.peliculas;

import  androidx.fragment.app.Fragment;

public  interface Navigation {

    void navigateTo(Fragment fragment, boolean addToBackstack);
}