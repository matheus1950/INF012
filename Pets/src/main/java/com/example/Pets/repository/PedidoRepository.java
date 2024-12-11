package com.example.Pets.repository;

import java.util.List;

import com.example.Pets.models.Pedido;

public interface PedidoRepository {
	public List<Pedido> findPedidoByClienteId(int id);
	public List<Pedido> findAll();
	public List<Pedido> findEmEstoque();
	public double valorTotal();
	public void alterarStatusDoPedido();
	public void cancelarPedido();
}
