package br.gov.cesarschool.poo.bonusvendas.tela;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.time.LocalDate;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.ResultadoInclusaoVendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Control;

public class TelaManutencaoVendedor {
	

	protected Shell shlBonusVendas;
	private Label lblNomeCompleto;
	private Text textNomeCompleto;
	private Label lblDataDeNascimento;
	private Text textDataDeNascimento;
	private Label lblSexo;
	private Label lblRenda;
	private Text textRenda;
	private Label lblEndereco;
	private Text textEndereco;
	private Label lblComplemento;
	private Text textComplemento;
	private Text textCpf;
	private Label lblCpf;
	private Label lblNumero;
	private Text textNumero;
	private Label lblCep;
	private Text textCep;
	private Label lblCidade;
	private Text textCidade;
	private Combo comboEstado;
	private Label lblEstado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaManutencaoVendedor window = new TelaManutencaoVendedor();
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
		shlBonusVendas.open();
		shlBonusVendas.layout();
		while (!shlBonusVendas.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBonusVendas = new Shell();
		shlBonusVendas.setSize(new Point(713, 958));
		shlBonusVendas.setBackground(SWTResourceManager.getColor(80, 80, 80));
		shlBonusVendas.setText("Bonus Vendas");
		
		
		
		// TEXT-BOX
		
		textCpf = new Text(shlBonusVendas, SWT.BORDER);
	    textCpf.setBounds(68, 96, 151, 31);

	    ModifyListener[] cpfListenerContainer = new ModifyListener[1];

	    cpfListenerContainer[0] = e -> {
	        String cpf = textCpf.getText();
	        cpf = cpf.replaceAll("[^0-9]", "");
	        
	        if (cpf.length() > 11) {
	            cpf = cpf.substring(0, 11);
	        }
	        
	        StringBuilder formattedCpf = new StringBuilder(cpf);

	        if (formattedCpf.length() > 3) {
	            formattedCpf.insert(3, '.');
	        }
	        if (formattedCpf.length() > 7) {
	            formattedCpf.insert(7, '.');
	        }
	        if (formattedCpf.length() > 11) {
	            formattedCpf.insert(11, '-');
	        }

	        textCpf.removeModifyListener(cpfListenerContainer[0]);
	        textCpf.setText(formattedCpf.toString());
	        textCpf.setSelection(formattedCpf.length());  // move the caret to the end
	        textCpf.addModifyListener(cpfListenerContainer[0]);
	    };

	    textCpf.addModifyListener(cpfListenerContainer[0]);

		

		textNomeCompleto = new Text(shlBonusVendas, SWT.BORDER);
		textNomeCompleto.setEnabled(false);
		textNomeCompleto.setBounds(68, 237, 460, 31);
		
		textDataDeNascimento = new Text(shlBonusVendas, SWT.BORDER);
		textDataDeNascimento.setEnabled(false);
		textDataDeNascimento.setBounds(68, 321, 214, 31);
		
		textRenda = new Text(shlBonusVendas, SWT.BORDER);
		textRenda.setEnabled(false);
		textRenda.setBounds(68, 411, 214, 31);
		
		textEndereco = new Text(shlBonusVendas, SWT.BORDER);
		textEndereco.setEnabled(false);
		textEndereco.setBounds(68, 513, 381, 31);
		
		textComplemento = new Text(shlBonusVendas, SWT.BORDER);
		textComplemento.setEnabled(false);
		textComplemento.setBounds(68, 592, 381, 31);
		
		textNumero = new Text(shlBonusVendas, SWT.BORDER);
		textNumero.setEnabled(false);
		textNumero.setBounds(474, 513, 83, 31);
		
		textCep = new Text(shlBonusVendas, SWT.BORDER);
		textCep.setEnabled(false);
		textCep.setBounds(475, 592, 120, 31);
		
		textCidade = new Text(shlBonusVendas, SWT.BORDER);
		textCidade.setEnabled(false);
		textCidade.setBounds(68, 680, 221, 31);
		
		comboEstado = new Combo(shlBonusVendas, SWT.NONE);
		comboEstado.setEnabled(false);
		comboEstado.setBounds(324, 678, 70, 33);
		
		
		Button btnFeminino = new Button(shlBonusVendas, SWT.RADIO);
		btnFeminino.setEnabled(false);
		btnFeminino.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnFeminino.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnFeminino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFeminino.setBounds(308, 321, 102, 25);
		btnFeminino.setText("Feminino");
		
		Button btnMasculino = new Button(shlBonusVendas, SWT.RADIO);
		btnMasculino.setEnabled(false);
		btnMasculino.setBackground(SWTResourceManager.getColor(80, 80, 80));
		btnMasculino.setForeground(SWTResourceManager.getColor(241, 241, 241));
		btnMasculino.setText("Masculino");
		btnMasculino.setBounds(414, 321, 169, 25);
		
		
		
		// BUTTON
		
	
		Button btnConfirmar = new Button(shlBonusVendas, SWT.NONE);
		btnConfirmar.setEnabled(false);
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			 @Override
			    public void widgetSelected(SelectionEvent e) {
			        Sexo selectedSex = btnFeminino.getSelection() ? Sexo.FEMININO : Sexo.MASCULINO;
			        Endereco endereco = new Endereco(
			        	    textEndereco.getText(),
			        	    Integer.parseInt(textNumero.getText()),
			        	    textComplemento.getText(),
			        	    textCep.getText(),
			        	    textCidade.getText(),
			        	    comboEstado.getText(),
			        	    "Brasil"
			        	);
			        Vendedor vendedor = new Vendedor(
			            textCpf.getText(),
			            textNomeCompleto.getText(),
			            selectedSex,
			            LocalDate.of(1987, 11, 21),
			            Double.parseDouble(textRenda.getText()),
			            endereco
			        );
			        
			        VendedorMediator mediator = VendedorMediator.getInstance();
			        ResultadoInclusaoVendedor result = mediator.incluir(vendedor);
			        

			    }
			});
		btnConfirmar.setForeground(SWTResourceManager.getColor(0, 153, 0));
		btnConfirmar.setBounds(539, 789, 105, 35);
		btnConfirmar.setText("Confirmar");

		Button btnCancelar = new Button(shlBonusVendas, SWT.NONE);
		btnCancelar.setEnabled(false);
		btnCancelar.setText("Cancelar");
		btnCancelar.setForeground(SWTResourceManager.getColor(208, 0, 0));
		btnCancelar.setBounds(416, 789, 105, 35);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // Disable all fields except for CPF and reset them to their default values
		    	textCpf.setText("");
		        textNomeCompleto.setText("");
		        textNomeCompleto.setEnabled(false);
		        textDataDeNascimento.setText("");
		        textDataDeNascimento.setEnabled(false);
		        textRenda.setText("");
		        textRenda.setEnabled(false);
		        textEndereco.setText("");
		        textEndereco.setEnabled(false);
		        textComplemento.setText("");
		        textComplemento.setEnabled(false);
		        textNumero.setText("");
		        textNumero.setEnabled(false);
		        textCep.setText("");
		        textCep.setEnabled(false);
		        textCidade.setText("");
		        textCidade.setEnabled(false);
		        comboEstado.deselectAll();
		        comboEstado.setEnabled(false);
		        btnFeminino.setSelection(false);
		        btnFeminino.setEnabled(false);
		        btnMasculino.setSelection(false);
		        btnMasculino.setEnabled(false);
		        btnConfirmar.setEnabled(false);
		        btnCancelar.setEnabled(false);
		    }
		});
		Button btnBuscar = new Button(shlBonusVendas, SWT.NONE);
		btnBuscar.setText("Buscar");
		btnBuscar.setBounds(250, 94, 105, 35);
		
		
		Button btnCadastrar = new Button(shlBonusVendas, SWT.NONE);
		btnCadastrar.setForeground(SWTResourceManager.getColor(255, 255, 255));
		btnCadastrar.setBackground(SWTResourceManager.getColor(0, 0, 0));
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setBounds(370, 96, 105, 33);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			    if (!textCpf.getText().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
			        MessageBox dialog = new MessageBox(shlBonusVendas, SWT.ERROR | SWT.OK);
			        dialog.setText("Erro");
			        dialog.setMessage("Formato do campo CPF inválido!");
			        dialog.open();
			        return; 
			    }
				textNomeCompleto.setEnabled(true);
		        textDataDeNascimento.setEnabled(true);
		        textRenda.setEnabled(true);
		        textEndereco.setEnabled(true);
		        textComplemento.setEnabled(true);
		        textNumero.setEnabled(true);
		        textCep.setEnabled(true);
		        textCidade.setEnabled(true);
		        comboEstado.setEnabled(true);
		        btnFeminino.setEnabled(true);
		        btnMasculino.setEnabled(true);
		        btnConfirmar.setEnabled(true);
		        btnCancelar.setEnabled(true);
			}
		});

		
		// DESIGN
		
		
		lblCpf = new Label(shlBonusVendas, SWT.NONE);
		lblCpf.setText("CPF");
		lblCpf.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblCpf.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblCpf.setBounds(68, 65, 35, 25);
			
		lblNomeCompleto = new Label(shlBonusVendas, SWT.NONE);
		lblNomeCompleto.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblNomeCompleto.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblNomeCompleto.setText("Nome Completo");
		lblNomeCompleto.setBounds(68, 206, 151, 25);
		
		lblDataDeNascimento = new Label(shlBonusVendas, SWT.NONE);
		lblDataDeNascimento.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblDataDeNascimento.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblDataDeNascimento.setText("Data de Nascimento");
		lblDataDeNascimento.setBounds(68, 290, 174, 25);

		lblSexo = new Label(shlBonusVendas, SWT.NONE);
		lblSexo.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblSexo.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblSexo.setText("Sexo");
		lblSexo.setBounds(308, 290, 81, 25);
		
		lblRenda = new Label(shlBonusVendas, SWT.NONE);
		lblRenda.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblRenda.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblRenda.setText("Renda");
		lblRenda.setBounds(68, 380, 81, 25);
	
		lblEndereco = new Label(shlBonusVendas, SWT.NONE);
		lblEndereco.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblEndereco.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblEndereco.setText("Endereço");
		lblEndereco.setBounds(68, 482, 81, 25);
		
		lblComplemento = new Label(shlBonusVendas, SWT.NONE);
		lblComplemento.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblComplemento.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblComplemento.setText("Complemento");
		lblComplemento.setBounds(68, 561, 126, 25);
		
		lblNumero = new Label(shlBonusVendas, SWT.NONE);
		lblNumero.setText("Número");
		lblNumero.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblNumero.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblNumero.setBounds(474, 482, 81, 25);

		lblCep = new Label(shlBonusVendas, SWT.NONE);
		lblCep.setText("CEP");
		lblCep.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblCep.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblCep.setBounds(475, 561, 81, 25);
		
		lblCidade = new Label(shlBonusVendas, SWT.NONE);
		lblCidade.setText("Cidade");
		lblCidade.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblCidade.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblCidade.setBounds(68, 649, 81, 25);
		
		lblEstado = new Label(shlBonusVendas, SWT.NONE);
		lblEstado.setText("Estado\r\n");
		lblEstado.setForeground(SWTResourceManager.getColor(214, 214, 214));
		lblEstado.setBackground(SWTResourceManager.getColor(80, 80, 80));
		lblEstado.setBounds(324, 649, 81, 25);
		
		Label horizLine = new Label(shlBonusVendas, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizLine.setForeground(SWTResourceManager.getColor(99, 99, 99));
		horizLine.setBackground(SWTResourceManager.getColor(99, 99, 99));
		horizLine.setBounds(70, 171, 321, 2);
		shlBonusVendas.setTabList(new Control[]{textCpf, btnBuscar, btnCadastrar, textNomeCompleto, textDataDeNascimento, btnFeminino, btnMasculino, textRenda, textEndereco, textNumero, textComplemento, textCep, textCidade, comboEstado, btnCancelar, btnConfirmar});

		Label logoVendedor = new Label(shlBonusVendas, SWT.NONE);
		logoVendedor.setForeground(SWTResourceManager.getColor(255, 255, 255));
		logoVendedor.setBackground(SWTResourceManager.getColor(80, 80, 80));
		logoVendedor.setAlignment(SWT.CENTER);
		logoVendedor.setFont(SWTResourceManager.getFont("Bahnschrift", 20, SWT.BOLD));
		logoVendedor.setBounds(439, 10, 281, 49);
		logoVendedor.setText("Vendedor");
		
	}
	
}
	