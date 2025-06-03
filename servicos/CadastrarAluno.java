package servicos;

import modelos.Aluno;
import repositorio.AlunoRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CadastrarAluno {
        public static void cadastrarAluno(String nomeStr, String cpfStr, String dataNascimentoStr, String telefoneStr, String emailStr){
            try {
                String nome = nomeStr.trim();
                
                String cpf = cpfStr.trim();
                //3 dígitos + [ponto opcional] + 3 dígitos + [ponto opcional] + 3 dígitos + [hífen opcional] + 2 dígitos
                if (!cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")) {
                    throw new IllegalArgumentException("Formato de CPF inválido. Use XXX.XXX.XXX-XX");
                }                
                               
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr.trim(), fmt);
                if (dataNascimento.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("Data de nascimento não pode ser futura!");
                }
                
                String telefone = telefoneStr.trim();
                if (!telefone.isEmpty() && !telefone.matches("^(?:\\(\\d{2}\\)|\\d{2})\\s*\\d{4,5}-?\\d{4}$")) {
                    throw new IllegalArgumentException("Formato inválido! Use:\n" +
                                                        "- Celular: (DDD) 91234-1234\n" +
                                                        "- Fixo: (DDD) 1234-5678");
                }
                
                String email = emailStr.trim();
                if (!email.isEmpty() && !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$")) {
                    throw new IllegalArgumentException("Formato de email invalido!");
                }
                
                AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
                alunoRepositorio.criarTabelaAluno();
                Aluno aluno = new Aluno(null, nome, cpf, dataNascimento, telefone, email);
                alunoRepositorio.inserir(aluno);
                
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Data deve ser no formato DIA/MES/ANO");
            } catch (IllegalArgumentException e){
                throw e;
            }
            catch (Exception e) {
                throw new RuntimeException("Erro ao cadastrar aluno. " + e.getMessage());
            }

    }
}
