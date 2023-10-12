package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaAcumuloResgate {

	protected Shell shell;
	private Text textSaldoAtual;
	private Text textValor;
	private Text textNrCaixaDeBonus;

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
		shell.setSize(459, 720);
		shell.setBackground(SWTResourceManager.getColor(80, 80, 80));
		shell.setText("Bonus Vendas");
		
		// TEXT-BOXES
		
		textNrCaixaDeBonus = new Text(shell, SWT.BORDER);
		textNrCaixaDeBonus.setBounds(39, 101, 158, 31);
		
		textSaldoAtual = new Text(shell, SWT.BORDER);
		textSaldoAtual.setBounds(147, 329, 158, 31);
		
		textValor = new Text(shell, SWT.BORDER);
		textValor.setBounds(36, 419, 80, 31);
		
		
		// BUTTONS
		
	
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(39, 230, 105, 35);
		btnBuscar.setText("Buscar");
		
		Button btnRadioAcumulo = new Button(shell, SWT.RADIO);
		btnRadioAcumulo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioAcumulo.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnRadioAcumulo.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnRadioAcumulo.setBounds(39, 180, 98, 25);
		btnRadioAcumulo.setText("Acumulo");
		
		
		Button btnRadioResgate = new Button(shell, SWT.RADIO);
		btnRadioResgate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioResgate.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnRadioResgate.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnRadioResgate.setBounds(143, 180, 98, 25);
		btnRadioResgate.setText("Resgate");
		

		
		Combo comboTipoDeResgate = new Combo(shell, SWT.NONE);
		comboTipoDeResgate.setBounds(36, 500, 104, 33);
		
		
		Button btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.setBounds(275, 590, 126, 35);
		btnConfirmar.setText("AcumularResgatar");
		
		
		Button btnCancelar = new Button(shell, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancelar.setBounds(148, 590, 105, 35);
		btnCancelar.setText("Voltar");
		
		
		
		//DESIGN
		
		Label lblValor = new Label(shell, SWT.NONE);
		lblValor.setBounds(36, 391, 81, 25);
		lblValor.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblValor.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblValor.setText("Valor");
		
		Label lblSaldoAtual = new Label(shell, SWT.NONE);
		lblSaldoAtual.setBounds(36, 332, 105, 25);
		lblSaldoAtual.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblSaldoAtual.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblSaldoAtual.setText("Saldo Atual");
		
		Label lblOperacao = new Label(shell, SWT.NONE);
		lblOperacao.setBounds(39, 149, 81, 25);
		lblOperacao.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblOperacao.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblOperacao.setText("Operação");
		
		Label lblTipoDeResgate = new Label(shell, SWT.NONE);
		lblTipoDeResgate.setBounds(36, 469, 134, 25);
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
		lblBonus.setBounds(275, 10, 175, 48);
		lblBonus.setText("Bonus");

	}
}
