package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class ExecutarApp {
	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 5; qtd++) {

			String nome = JOptionPane.showInputDialog("Qual o nome do aluno" + qtd + "?");
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
			if (escolha == 0) {
				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina?(1, 2, 3 ou 4)");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover? ");
				}

			}
			alunos.add(aluno1);
		}

		for (Aluno aluno : alunos) { /* separei os alunos em listas conforme os status */
			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
				alunosReprovados.add(aluno);
			}
		}
		System.out.println("----------Lista dos alunos aprovados: ----------");
		for (Aluno aluno : alunosAprovados) {
			System.out.println("Resultado: " + aluno.getNome() + " está " + aluno.getAlunoAprovado2()
					+ " com média de: " + aluno.getMedia());
		}
		System.out.println("----------Lista dos alunos reprovados: ----------");
		for (Aluno aluno : alunosReprovados) {
			System.out.println("Resultado: " + aluno.getNome() + " está " + aluno.getAlunoAprovado2()
					+ " com média de: " + aluno.getMedia());

		}
		System.out.println("----------Lista dos alunos em recuperação: ----------");
		for (Aluno aluno : alunosRecuperacao) {
			System.out.println("Resultado: " + aluno.getNome() + " está em recuperação " + aluno.getAlunoAprovado2()
					+ " com média de: " + aluno.getMedia());

		}

	}
}
