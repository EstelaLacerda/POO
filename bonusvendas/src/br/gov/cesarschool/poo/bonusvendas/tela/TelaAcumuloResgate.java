package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.ResultadoInclusaoVendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaAcumuloResgate {

	protected Shell shell;
	private Text textSaldoAtual;
	private Text textValor;
	private Text textNrCaixaDeBonus;
	private Button btnConfirmar;
	private Button btnCancelar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaAcumuloResgate window = new TelaAcumuloResgate();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(803, 449);
		shell.setBackground(SWTResourceManager.getColor(80, 80, 80));
		shell.setText("Bonus Vendas");
		
		// TEXT-BOXES
		
		textNrCaixaDeBonus = new Text(shell, SWT.BORDER);
		textNrCaixaDeBonus.setBounds(39, 101, 158, 31);
		ModifyListener[] numeroListenerContainer = new ModifyListener[1];

		numeroListenerContainer[0] = e -> {
		    String numero = textNrCaixaDeBonus.getText();
		    numero = numero.replaceAll("[^0-9]", "");

		    textNrCaixaDeBonus.removeModifyListener(numeroListenerContainer[0]);
		    textNrCaixaDeBonus.setText(numero);
		    textNrCaixaDeBonus.setSelection(numero.length());
		    textNrCaixaDeBonus.addModifyListener(numeroListenerContainer[0]);
		};

		textNrCaixaDeBonus.addModifyListener(numeroListenerContainer[0]);
		
		
		textSaldoAtual = new Text(shell, SWT.BORDER|SWT.READ_ONLY);
		textSaldoAtual.setEnabled(false);
		textSaldoAtual.setBounds(469, 64, 158, 31);
		
		
		
		textValor = new Text(shell, SWT.BORDER);
		textValor.setEnabled(false);
		textValor.setBounds(358, 154, 80, 31);
		ModifyListener[] valorListenerContainer = new ModifyListener[1];

		valorListenerContainer[0] = e -> {
		    String valor = textValor.getText();
		    valor = valor.replaceAll("[^0-9]", "");
		    
		    StringBuilder formattedValor = new StringBuilder(valor);
		    
		    while (formattedValor.length() < 3) {
		        formattedValor.insert(0, '0');
		    }

		    formattedValor.insert(formattedValor.length() - 2, '.');
		    
		    if (formattedValor.length() - formattedValor.indexOf(".") > 3) {
		        formattedValor = new StringBuilder(formattedValor.substring(0, formattedValor.indexOf(".") + 3));
		    }

		    textValor.removeModifyListener(valorListenerContainer[0]);
		    textValor.setText(formattedValor.toString());
		    textValor.setSelection(formattedValor.length());
		    textValor.addModifyListener(valorListenerContainer[0]);
		};

		textValor.addModifyListener(valorListenerContainer[0]);
		
		// BUTTONS
	
		Button btnRadioAcumulo = new Button(shell, SWT.RADIO);
		btnRadioAcumulo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnConfirmar.setText("Acumular");
			}
		});
		btnRadioAcumulo.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnRadioAcumulo.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnRadioAcumulo.setBounds(39, 180, 98, 25);
		btnRadioAcumulo.setText("Acumulo");
		btnRadioAcumulo.setSelection(true);
		
		
		Button btnRadioResgate = new Button(shell, SWT.RADIO);
		btnRadioResgate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnConfirmar.setText("Resgatar");
			}
		});
		btnRadioResgate.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnRadioResgate.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnRadioResgate.setBounds(143, 180, 98, 25);
		btnRadioResgate.setText("Resgate");
		
		
		
		Combo comboTipoDeResgate = new Combo(shell, SWT.READ_ONLY);
		comboTipoDeResgate.setEnabled(false);
		comboTipoDeResgate.setBounds(358, 235, 104, 33);
		
		String[] tiposResgate = {
			    "Produto", "Servico", "Cash"
			};
		
			for (String tipo : tiposResgate) {
			    comboTipoDeResgate.add(tipo);
			}
		
		
		btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(608, 325, 126, 35);
		btnConfirmar.setForeground(SWTResourceManager.getColor(0, 153, 0));
		btnConfirmar.setText("Acumular");
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			 @Override
			    public void widgetSelected(SelectionEvent e) {
				 	if(textNrCaixaDeBonus.getText().isEmpty() || 
				           textSaldoAtual.getText().isEmpty() ||
				           textValor.getText().isEmpty() ||
				           comboTipoDeResgate.getText().isEmpty() && btnRadioResgate.getSelection()
				           ){
				           MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
				           dialog.setText("Erro");
				           dialog.setMessage("Todos os campos sao obrigatorios");
				           dialog.open();
				           return;
				        }
				 	
				 	long numCaixa = Long.parseLong(textNrCaixaDeBonus.getText());
				 	double valor = Double.parseDouble(textValor.getText());
				 	
				 	AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstance();

			        String message = "";

			        if(btnRadioResgate.getSelection()) {
			            TipoResgate tipoResgate = TipoResgate.valueOf(comboTipoDeResgate.getText().toUpperCase());
			            message = mediator.resgatar(numCaixa, valor, tipoResgate);
			        } else {
			            message = mediator.acumularBonus(numCaixa, valor);
			        }

			        if (message != null && !message.isEmpty()) {
		                MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
		                dialog.setText("Resultado");
		                dialog.setMessage(message);
		                dialog.open();
		            } else {
		                MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
		                dialog.setText("Sucesso");
		                dialog.setMessage("Operação realizada com sucesso!");
		                dialog.open();
		            }
			        textNrCaixaDeBonus.setText("");
					textSaldoAtual.setText("");
					textValor.setText("");
					comboTipoDeResgate.deselectAll();
					
					textSaldoAtual.setEnabled(false);
					textValor.setEnabled(false);
					comboTipoDeResgate.setEnabled(false);
					btnCancelar.setEnabled(false);
					btnConfirmar.setEnabled(false);
					
					textNrCaixaDeBonus.setEnabled(true);
			    	btnRadioAcumulo.setEnabled(true);
			    	btnRadioResgate.setEnabled(true);
			    }
			});
		
		btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.setEnabled(false);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textNrCaixaDeBonus.setText("");
				textSaldoAtual.setText("");
				textValor.setText("");
				comboTipoDeResgate.deselectAll();
				
				textSaldoAtual.setEnabled(false);
				textValor.setEnabled(false);
				comboTipoDeResgate.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnConfirmar.setEnabled(false);
				
				textNrCaixaDeBonus.setEnabled(true);
		    	btnRadioAcumulo.setEnabled(true);
		    	btnRadioResgate.setEnabled(true);
			}
		});
		btnCancelar.setBounds(482, 325, 105, 35);
		btnCancelar.setForeground(SWTResourceManager.getColor(208, 0, 0));
		btnCancelar.setText("Voltar");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(39, 230, 105, 35);
		btnBuscar.setText("Buscar");
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstance();
				CaixaDeBonus caixaDeBonus = mediator.buscar(Long.parseLong(textNrCaixaDeBonus.getText().replaceAll("[^0-9]", "")));
				
			    if (caixaDeBonus != null) {
			    	textSaldoAtual.setEnabled(true);
			    	textSaldoAtual.setText(""+caixaDeBonus.getSaldo());
			    	
			    	textValor.setEnabled(true);
			    	textValor.setText(""+0.0);
			    	
			    	btnConfirmar.setEnabled(true);
			    	btnCancelar.setEnabled(true);
			    	
			    	textNrCaixaDeBonus.setEnabled(false);
			    	btnRadioAcumulo.setEnabled(false);
			    	btnRadioResgate.setEnabled(false);
			    	
			    	if(btnRadioResgate.getSelection()) {
			    		comboTipoDeResgate.setEnabled(true);    		
			    	}
			    	else {
			    		comboTipoDeResgate.setEnabled(false);
			    	}		      
			    } else {
			        MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
			        dialog.setText("Erro");
			        dialog.setMessage("Caixa de Bonus nao encontrada!");
			        dialog.open();
			    }
			}
		});
		
		//DESIGN
		
		Label lblValor = new Label(shell, SWT.NONE);
		lblValor.setBounds(358, 126, 81, 25);
		lblValor.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblValor.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblValor.setText("Valor");
		
		Label lblSaldoAtual = new Label(shell, SWT.NONE);
		lblSaldoAtual.setBounds(358, 67, 105, 25);
		lblSaldoAtual.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblSaldoAtual.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblSaldoAtual.setText("Saldo Atual");
		
		Label lblOperacao = new Label(shell, SWT.NONE);
		lblOperacao.setBounds(39, 149, 81, 25);
		lblOperacao.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblOperacao.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblOperacao.setText("Operação");
		
		Label lblTipoDeResgate = new Label(shell, SWT.NONE);
		lblTipoDeResgate.setBounds(358, 204, 134, 25);
		lblTipoDeResgate.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblTipoDeResgate.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblTipoDeResgate.setText("Tipo de resgate");
		
		Label lblNmeroDaCaixa = new Label(shell, SWT.NONE);
		lblNmeroDaCaixa.setBounds(39, 59, 243, 25);
		lblNmeroDaCaixa.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblNmeroDaCaixa.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblNmeroDaCaixa.setText("Número da Caixa de Bonus");
		
		Label lblBonus = new Label(shell, SWT.NONE);
		lblBonus.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblBonus.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblBonus.setAlignment(SWT.CENTER);
		lblBonus.setFont(SWTResourceManager.getFont("Bahnschrift", 20, SWT.BOLD));
		lblBonus.setBounds(624, 10, 175, 48);
		lblBonus.setText("Bonus");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(298, 59, 2, 245);

	}
}
