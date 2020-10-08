import java.util.Scanner;

public class FolhaDePagamento {
private static Scanner input = new Scanner(System.in);
	
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static String[][] empregado = new String[100][13];
	private static int numeroEmpregado = 19000, numeroSindicato = 191000, operacao;
	private static int contadorLinha = 0, contadorColuna = 0, dia = 1, mes = 1, ano = 2020;
	private static String diaSemana = "Quarta-Feira";
	
	
	public static void main(String[] args) {
		boolean executar = true;
		
		inicializarBancoDeDados(empregado);
		
		while(executar) {
			System.out.println("Operação:\n1 - Cadastro novo.\n2 - Remoção de cadastro."
				+ "\n3 - Lançar cartão de ponto.\n4 - Lançar resultado de venda."
				+ "\n5 - Lançar taxa de serviço.\n6 - Alterar cadastro."
				+ "\n7 - Rodar folha de pagamento.\n8 - Consultar agenda de pagamento."
				+ "\n9 - Avançar dia."
				+ "\n0 - Encerrar programa.");
		
			operacao = input.nextInt();
		
			switch (operacao) {
				case 0:
					executar = false;
					break;
				case 1:
					adicionarEmpregado(empregado);
					break;
				case 2:
					removerEmpregado(empregado);
					break;
				case 3:
					lancarCartaoDePonto(empregado);
					break;
				case 4:
					lancarResultadoDeVenda(empregado);
					break;
				case 5:
					lancarTaxaDeServico(empregado);
					break;
				case 6:
					alterarCadastro(empregado);
					break;
				case 7:
					rodarFolhaDePagamento(empregado);
					break;
				case 8:
					consultarAgenda(empregado);
					break;
				case 9:
					calendario();
					break;
				
			}
		}
		
	}
	
	
	/****************************************************************************
	**********       INICIALIZAR BANCO DE DADOS *********************************
	****************************************************************************/
	private static void inicializarBancoDeDados(String[][] empregado) {
		for(int i = 0; i < 100; i ++) {
			for(int j = 0; i < j; j++) {
				empregado[i][j] = null;
			}
		}
	}
	
	
	/****************************************************************************
	**********       CADASTRAR EMPREGADO        *********************************
	****************************************************************************/
		//0 - Nome
		//1 - Número do empregado
		//2 - Endereço
		//3 - Tipo de salário
		//4 - Tributo de salário
		//5 - Método de pagamento
		//6 - Pertence ao sindicato?
		//7 - Número do sindicato
		//8 - Taxa sindical
		//9 - Salário acumulado
		//10 - Taxa de serviço
		//11 - Cartão de ponto: entrada - saída
		//12 - Dia de pagamento
	private static void adicionarEmpregado(String[][] empregado) {
		boolean controle = false;
		System.out.println("Informe os dados do empregado.");
		System.out.println("Nome:");
		empregado[contadorLinha][0] = input.next();
		
		empregado[contadorLinha][1] = Integer.toString(numeroEmpregado);
		numeroEmpregado++;
		
		System.out.println("Endereço:");
		empregado[contadorLinha][2] = input.next();
		
		while(controle == false) {
			System.out.println("Tipo de salário:\n1 - Horista. \n"
					+ "2 - Assalariado. \n3 - Comissionado.");
			operacao = input.nextInt();
			if(operacao == 1) {
				empregado[contadorLinha][3] = "Horista";
				contadorColuna++;
				
				System.out.println("Tributo por hora:");
				empregado[contadorLinha][4] = input.next();
				
				controle = true;
				
			} else if(operacao == 2) {
				empregado[contadorLinha][3] = "Assalariado";
				contadorColuna++;
				
				System.out.println("Salário mensal:");
				empregado[contadorLinha][4] = input.next();

				controle = true;
					
			} else if(operacao == 3){
				empregado[contadorLinha][3] = "Comissionado";
				contadorColuna++;
				
				System.out.println("Comissão:");
				empregado[contadorLinha][4] = input.next();

				controle = true;
				
			} else {
				System.out.println("Entrada inválida, tente novamente.");
			}
			contadorColuna++;
		}
		
		controle = false;
			
		while (controle == false) {
			System.out.println("Método de pagamento:\n1 - Cheque pelos correios.\n"
					+ "2 - Depósito em banco. \n3 - Em mãos");
			operacao = input.nextInt();
			if(operacao == 1) {
				empregado[contadorLinha][5] = "Cheque";
				controle = true;
				
			} else if(operacao == 2) {
				empregado[contadorLinha][5] = "Depósito";
				controle = true;
	
			} else if(operacao == 3){
				empregado[contadorLinha][5] = "Em mãos";
				controle = true;
				
			} else {
				System.out.println("Entrada inválida, tente novamente.");
			}
			contadorColuna++;
		}
		
		controle = false;
		
		while (controle == false) {
			System.out.println("Pertence ao sindicato?\n 1- Sim.\n 2 - Não.");
			operacao = input.nextInt();
			if(operacao == 1) {
				empregado[contadorLinha][6] = "Sim.";
				contadorColuna++;
				
				empregado[contadorLinha][7] = Integer.toString(numeroSindicato);
				contadorColuna++;
				
				System.out.println("Qual a taxa sindical?");
				empregado[contadorLinha][8] = input.next();
				
				controle = true;
			} else if (operacao == 2){
				empregado[contadorLinha][6] = "Não";
				contadorColuna++;
				empregado[contadorLinha][7] = null;
				contadorColuna++;
				empregado[contadorLinha][8] = null;
				
				controle = true;
			} else {
				System.out.println("Entrada inválida, tente novamente.");
			}
			contadorColuna++;
		}
			
		empregado[contadorLinha][12] = "30";
		
		System.out.println("Empregado cadastrado.");
		System.out.println("Número do empregado: " + empregado[contadorLinha][1]);
		if(empregado[contadorLinha][7] != null) {
			System.out.println("Número do sindicato do empregado: " + empregado[contadorLinha][7]);		
		}
		System.out.printf("\n\n\n\n\n");
		contadorLinha++;
	}
	
	
	
	/****************************************************************************
	**********       REMOVER EMPREGADO        ***********************************
	****************************************************************************/
	private static void removerEmpregado(String[][] empregado) {
		String numeroEmpregado;
		int i, j;
		System.out.println("Remover empregado através do:\n1 - Número.\n"
				+ "0 - Cancelar operação.");
		operacao = input.nextInt();
		if(operacao == 1) {
			System.out.println("Digite o número do empregado:");
			numeroEmpregado = input.next();
			for(i = 0; i < 100; i++) {
				if(empregado[i][0] != null && empregado[i][1].equalsIgnoreCase(numeroEmpregado)){
					System.out.println("Dados do empregado:");
					for(j = 0; j < 3; j++) {
						if(empregado[i][j] != null) {
							System.out.println("" + empregado[i][j]);
						}
					}
					System.out.println("Confirmar remoção?\n1 - Sim.\n2 - Cancelar.");
					operacao = input.nextInt();
					if(operacao == 1) {
						for(j = 0; j < 11; j++) {
							empregado[i][j] = null;
						}
						System.out.println("Empregado removido.\n\n\n\n");
					} else {
						System.out.println("Operação cancelada.\n\n\n\n");
					}
					return;
				}
			}	
			System.out.println("Empregado não encontrado.\n\n\n\n\n\n");
		} else {
			System.out.println("Operação cancelada.\n\n\n\n");
			return;
		}
	}
	
	
	
	/****************************************************************************
	**********       LANCAR CARTAO DE PONTO        ******************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static void lancarCartaoDePonto(String[][] empregado) {
		int i;
		double entrada, saida, total;
		
		System.out.println("Número do empregado:");
		String numeroEmpregado = input.next();
		for(i = 0; i < 100; i++) {
			if(empregado[i][0] != null && empregado[i][1].equalsIgnoreCase(numeroEmpregado)){
				if(empregado[i][3].equalsIgnoreCase("Horista") == false) {
					System.out.println("O empregado não é horista.");
					return;
				}
				break;
			}
		}
		
		System.out.println("1 - Lançar entrada.\n2 - Lançar saída.");
		operacao = input.nextInt();
		if(operacao == 1) {
			System.out.println("Horário de entrada (formato: hora.minuto):");
			empregado[i][11] = input.next();
			empregado[i][11].replace(".", ",");
		} 
		else if(operacao == 2) {
			System.out.println("Horário de saída (formato: hora.minuto):");
			entrada = Double.parseDouble(empregado[i][11]);
			System.out.println("entrada " + entrada);
			saida = input.nextDouble();
			System.out.println("saida " + saida);
			total = saida - entrada;
			System.out.println("total " + total);
			total += Double.parseDouble(empregado[i][9]);

			System.out.println("total " + total);
			empregado[i][9] = Double.toString(total);
			empregado[i][11] = null;
		}
	}




	/****************************************************************************
	**********       LANCAR RESULTADO DE VENDA        ***************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static void lancarResultadoDeVenda(String[][] empregado) {
		int i;
		double valorVenda, comissao;
		
		System.out.println("Número do empregado:");
		String numeroEmpregado = input.next();
		
		for(i = 0; i < 100; i++) {
			
			if(empregado[i][1].equalsIgnoreCase(numeroEmpregado)){
				
				if(empregado[i][3].equalsIgnoreCase("Comissionado") == false) {
					System.out.println("O empregado não é comissionado.");
					return;	
				} else {
					System.out.println("Qual o valor da venda?");
					valorVenda = input.nextDouble();
					comissao = Double.parseDouble(empregado[i][4]);
					comissao = comissao * valorVenda;	
					empregado[i][9] = Double.toString(comissao);
				}
				return;
			}
		}
		System.out.println("Empregado não encontrado.\n\n\n\n\n\n");
		return;		
	}



	/****************************************************************************
	**********       LANCAR TAXA DE SERVIÇO        ******************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento	
	private static void lancarTaxaDeServico(String[][] empregado) {
		String numeroEmpregado, taxaServico;
		int i;
		
		System.out.println("Digite o número do empregado:");
		numeroEmpregado = input.next();
		for(i = 0; i < 100; i++) {
			
			if(empregado[i][1].equalsIgnoreCase(numeroEmpregado)){
				System.out.println("Digite o valor da taxa de serviço:");
				taxaServico = input.next();
				
				if(empregado[i][10] == null) {
					empregado[i][10] = taxaServico;
				} else {
					empregado[i][10] = Double.toString(Double.parseDouble(taxaServico)
							+ Double.parseDouble(empregado[i][10]));
				}
				return;
			}
		}
		System.out.println("Empregado não encontrado.\n\n\n\n\n\n");
		return;
	}

	
	/****************************************************************************
	**********       ALTERAR CADASTRO        ************************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static void alterarCadastro(String[][] empregado) {
		String numeroEmpregado, alteracao;
		int i, op, escolha;
		boolean controle = false;
		
		System.out.println("Digite o número do empregado:");
		numeroEmpregado = input.next();
		for(i = 0; i < 100; i++) {
			
			
			if(empregado[i][1].equalsIgnoreCase(numeroEmpregado)){
				while(controle == false) {
					System.out.println("O que deseja alterar?\n"
							+ "1 - Nome.\n"
							+ "2 - Endereco.\n"
							+ "3 - Tipo de salário.\n"
							+ "4 - Método de pagamento.\n"
							+ "5 - Status no sindicato.\n"
							+ "6 - Identificação no sindicato.\n"
							+ "7 - Taxa sindical.");
					op = input.nextInt();
			
					switch (op) {
						case 1:
							System.out.println("Digite o nome:");
							alteracao = input.next();
							empregado[i][0] = alteracao;
							return;
						case 2:
							System.out.println("Digite o endereco:");
							alteracao = input.next();
							empregado[i][2] = alteracao;
							return;				
						case 3:
							System.out.println("Digite o tipo de salario:");
							alteracao = input.next();
							empregado[i][3] = alteracao;
							return;
						case 4:
							System.out.println("Digite o metodo de pagamento:");
							alteracao = input.next();
							empregado[i][5] = alteracao;
							return;	
						case 5:
							if(empregado[i][6].equalsIgnoreCase("não")){
								System.out.println("O empregado não pertence ao sindicato. "
										+ "Deseja cadastrá-lo?\n"
										+ "1 - Sim. 2 - Não.");
								escolha = input.nextInt();
								if(escolha == 1) {
									empregado[i][6] = "Sim.";
									empregado[i][7] = Integer.toString(numeroSindicato++);
									System.out.println("O numero do sindicato é:" + numeroSindicato);
									System.out.println("Qual a taxa sindical?");
									alteracao = input.next();
									empregado[i][8] = alteracao;
								} else {
									return;
								}
							}
							return;	
						case 6:
							empregado[i][7] = Integer.toString(numeroSindicato++);
							System.out.println("O numero do sindicato é:" + numeroSindicato);
							return;
						case 7:
							System.out.println("Qual a nova taxa sindical?");
							alteracao = input.next();
							empregado[i][8] = alteracao;
							return;
						default:
							System.out.println("Operação inválida.");
					}	
				}
			}			
		}
	}
	
	
	/****************************************************************************
	**********       CONSULTAR AGENDA       *************************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static void consultarAgenda(String[][] empregado) {
		int op, i;
		String numeroEmpregado;
		
		System.out.println("Deseja consultar a agenda de pagamento:\n"
				+ "1 - Geral. \n2 - De um empregado.");
		op = input.nextInt();
		if(op == 1) {
			for(i = 0; i < 100; i ++) {
				if(empregado[i][0] != null) {
					System.out.println("Nome: " + empregado[i][0]);
					System.out.println("Número: " + empregado[i][1]);
					System.out.println("Data de pagamento: " + empregado[i][12]);
				}
			}
		} else {
			System.out.println("Digite o número do empregado:");
			numeroEmpregado = input.next();
			for(i = 0; i < 100; i ++) {
				if(empregado[i][1].equalsIgnoreCase(numeroEmpregado)) {
					System.out.println("Nome: " + empregado[i][0]);
					System.out.println("Número: " + empregado[i][1]);
					System.out.println("Data de pagamento: " + empregado[i][12]);
					return;
				}
			}
			System.out.println("Empregado não encontrado.\n\n\n\n\n\n");
			return;
		}
	}
	
	
	/****************************************************************************
	**********       RODAR FOLHA DE PAGAMENTO       *****************************
	****************************************************************************/
	//0 - Nome
	//1 - Número do empregado
	//2 - Endereço
	//3 - Tipo de salário
	//4 - Tributo de salário
	//5 - Método de pagamento
	//6 - Pertence ao sindicato?
	//7 - Número do sindicato
	//8 - Taxa sindical
	//9 - Salário acumulado
	//10 - Taxa de serviço
	//11 - Cartão de ponto: entrada - saída
	//12 - Dia de pagamento
	private static void rodarFolhaDePagamento(String[][] empregado) {
		int i, dataInt;
		String data = Integer.toString(dia);
		
		System.out.println("Hoje é dia " + dia + "do mês " + mes + "do ano de " + ano);
		
		
		for(i = 0; i < 100; i++) {
			if(empregado[i][0] != null) {
				if(empregado[i][3].equalsIgnoreCase("Assalariado") ) {
					if(empregado[i][12].equalsIgnoreCase(data)) {
						System.out.println("Empregado a ser pago:");
						System.out.println("Nome: " + empregado[i][0]);
						System.out.println("Número: " + empregado[i][1]);
						System.out.println("Tipo de salário: " + empregado[i][3]);
						System.out.println("Método de pagamento: " + empregado[i][5]);
						System.out.println("Valor a ser pago: " + empregado[i][9]);
						System.out.println("Empregado pago");
						empregado[i][9] = "0";
					}
				} else if(empregado[i][3].equalsIgnoreCase("Horista")) {
					if(diaSemana.equalsIgnoreCase("sexta-feira")) {
						System.out.println("Empregado a ser pago:");
						System.out.println("Nome: " + empregado[i][0]);
						System.out.println("Número: " + empregado[i][1]);
						System.out.println("Tipo de salário: " + empregado[i][3]);
						System.out.println("Método de pagamento: " + empregado[i][5]);
						System.out.println("Valor a ser pago: " + empregado[i][9]);
						System.out.println("Empregado pago");
						empregado[i][9] = "0";
					}
				} else if(empregado[i][3].equalsIgnoreCase("Comissionado")) {
					if(diaSemana.equalsIgnoreCase("sexta-feira")) {
						dataInt = Integer.parseInt(data);
						if(dataInt <= 14 && dataInt >= 20 ) {
							System.out.println("Empregado a ser pago:");
							System.out.println("Nome: " + empregado[i][0]);
							System.out.println("Número: " + empregado[i][1]);
							System.out.println("Tipo de salário: " + empregado[i][3]);
							System.out.println("Método de pagamento: " + empregado[i][5]);
							System.out.println("Valor a ser pago: " + empregado[i][9]);
							System.out.println("Empregado pago");
							empregado[i][9] = "0";
						}
					}
				}
			}
		}
		
		
		
	}
	
	
	/****************************************************************************
	************************       Calendário       *****************************
	****************************************************************************/
	
	private static void calendario() {
		if(diaSemana.equalsIgnoreCase("Segunda-Feira")) {
			diaSemana = "Terça-Feira";
		} else if (diaSemana.equalsIgnoreCase("Terça-Feira")) {
			diaSemana = "Quarta-Feira";
		} else if (diaSemana.equalsIgnoreCase("Quarta-Feira")) {
			diaSemana = "Quinta-Feira";
		} else if (diaSemana.equalsIgnoreCase("Quinta-Feira")) {
			diaSemana = "Sexta-Feira";
		} else if (diaSemana.equalsIgnoreCase("Sexta-Feira")) {
			diaSemana = "Sábado";
		} else if (diaSemana.equalsIgnoreCase("Sábado")) {
			dia++;
			diaSemana = "Segunda-Feira";
		}
		
		
		if(dia == 31) {
			dia = 1;
			mes++;
			if(mes == 12) {
				mes = 1;
				ano++;
			}
		} else if (dia == 30) {
			if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				dia = 1;
				mes++;
			} else {
				dia++;
			}
		} else if(dia == 29 && mes == 2) {
			dia = 1;
			mes++;
		} else {
			dia++;
		}
		
		System.out.println("Hoje é " + diaSemana + ", dia " + dia + " do mês " + mes + " do ano de " + ano);
	}
	
}
