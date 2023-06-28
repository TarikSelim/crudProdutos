package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "";
	private String user = "";
	private String password = "";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos (nome,valor,quantidade) values (?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getValor());
			pst.setString(3, produto.getQuantidade());
			// Executar a qquery
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarProdutos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado enquanto ouver contatos
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String valor = rs.getString(3);
				String quantidade = rs.getString(4);
				// populando o ArrayList
				produtos.add(new JavaBeans(idcon, nome, valor, quantidade));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD UPDATE**/
	//Selecionar o produto
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//setar as variáveis JavaBeans
				produto.setIdcon(rs.getString(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getString(3));
				produto.setQuantidade(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// editar o produto
	public void alterarProduto(JavaBeans produto) {
		String create = "update produtos set nome=?, valor=?, quantidade=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getValor());
			pst.setString(3, produto.getQuantidade());
			pst.setString(4, produto.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD DELETE **/
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produtos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
