package br.edu.ifsp.spo.lp2a4.spring.main;

import java.util.ArrayList;

import br.edu.ifsp.spo.lp2a4.spring.controller.CsvController;
import br.edu.ifsp.spo.lp2a4.spring.model.Results;

public class CsvStart {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		ArrayList<Results> results = new CsvController().loader("CsvProjeto.csv");
}
}