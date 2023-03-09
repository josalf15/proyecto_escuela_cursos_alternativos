package com.josalf.project.modelo;

import java.util.ArrayList;

public class PokemonResponse {

	public int count;
    public String next;
    public Object previous;
    public ArrayList<Resultado> results;
}

class Resultado{
    public String name;
    public String url;
}