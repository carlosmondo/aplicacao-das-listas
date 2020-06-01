# aplicacao-das-listas

SimpleLinkedList - Senhas Prioritarias
 - addFirst()
 - removeLast()
 - isEmpty()

SimpleLinkedList - Senhas Normais
 - addFirst()
 - removeLast()

SimpleLinkedList - Todas as Senhas
 - addFirst()
 - toArray()

##

Sistema deve ser implementado com os dados em memória. Sem banco de dados.

As senhas normais obedecem a ordem de chegada. O primeiro a chegar, o primeiro a ser atendido.

As senhas tipo prioritário, deve ser chamado antes das senhas normais. Entre as senhas prioritárias, deve ser obedecido a ordem de chegada.

O funcionário desconhece qual o tipo da próxima senha. Apenas clica no botão “próxima senha”.

O painel exibe a senha em atendimento.

O painel exibe a lista das últimas senhas atendidas.

##

```java
public class Senha(){
	public String type;
	public int numero;
	public Date data;
}
```

Identifique qual tipo de lista é mais eficiente para implementar o Sistema proposto. Justifique suas escolhas demonstrando os métodos das listas que deverão ser utilizados.

- Senhas geradas (Normais e prioritárias)
- Próxima Senha
- Histórico de senhas atendidas

