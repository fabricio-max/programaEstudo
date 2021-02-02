package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class ExecutarApp {
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		for(int qtd = 1; qtd <= 2; qtd++) {
			
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno"+qtd+"?");
		String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");

		Aluno aluno1 = new Aluno();
		aluno1.setNome(nome);
		aluno1.setIdade(Integer.valueOf(idade));

		for (int pos = 1; pos <= 1; pos++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + ": ");
			String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina" + pos + ": ");
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
		if(escolha == 0) {
			int continuarRemover = 0;
			int posicao = 1;
			
			while(continuarRemover == 0) {
				String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina?(1, 2, 3 ou 4)");
				aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() -posicao);
				posicao++;
				continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover? ");
			}
			
		}
		alunos.add(aluno1);
	}
		/*String alunoNome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(alunoNome)) { 
				System.out.println("Nome do aluno : " + aluno.getNome());
				System.out.println("Idade do aluno : " + aluno.getIdade());
				System.out.println(aluno.toString()); 
				System.out.println("Média do aluno = " + aluno.getMedia());
				System.out.println("Resultado = " + (aluno.getAlunoAprovado()? "Aluno Aprovado!" : "Aluno Reprovado!"));
				System.out.println(aluno.getDisciplinas());
				System.out.println("Situação do aluno: " + aluno.getAlunoAprovado2());
				System.out.println("*****************************************************");
				break;
			}
			
		} */ 
		
		for ( Aluno aluno : alunos) {
			System.out.println("Suas matérias são: ");
			for (Disciplina disciplina : aluno.getDisciplinas()) {
				System.out.print("Matéria = "+disciplina.getDisciplina());
				System.out.print("  Nota = " + disciplina.getNota());
				System.out.println("");
			}
		}
		System.out.println("****************** percorrendo lista ***********************");
		
		String alunoNome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		
		for (int pos = 0; pos < alunos.size(); pos++) {
			Aluno aluno = alunos.get(pos);
			if(aluno.getNome().equalsIgnoreCase(alunoNome)) {
			Aluno trocar = new Aluno();
			trocar.setNome("Aluno foi trcado");
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina("Matemática");
			disciplina.setNota(96);
			
			trocar.getDisciplinas().add(disciplina);
			alunos.set(pos, trocar);
			aluno = alunos.get(pos);
			}
			
			Aluno aluno01 = alunos.get(pos);
			System.out.println("Aluno = " + aluno01.getNome());
			System.out.println("Média do aluno =" + aluno01.getMedia());
			System.out.println("Resultado =" + aluno01.getAlunoAprovado2());
			System.out.println("----------------------------------------------------");
		}
		
		
		
	}
}
