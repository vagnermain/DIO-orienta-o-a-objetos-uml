@startuml
title Orientação a Objetos e UML: Diagramação de Classes do iPhone

skinparam classAttributeIconSize 0
interface "Reprodutor Musical" as ReprodutorMusical {
  -Musica[] musicas
  +tocar(): void
  +pausar(): void
  +selecionarMusica(): void
}
note top of ReprodutorMusical
  Interface encarregada de implementar
  a funcionalidade de reprodução de 
  arquivos de áudio.
end note

note top of AparelhoTelefonico
  Interface encarregada de implementar
  a funcionalidade de um telefone.
end note

note top of Musica
  Classe responsável por 
  armazenar informações 
  das músicas.
end note

class Musica {
  nome: String
  caminho: String
}

note top of Contato
  Classe responsável por 
  armazenar informações 
  de contato.
end note

class Contato {
  nome: String
  numero: String
}

interface "Aparelho Telefônico" as AparelhoTelefonico {
  -Contato[] contatos
  -redeMovelDisponivel(): Boolean
  +ligar(): void
  +atender(): void
  +iniciarCorreioVoz(): void
}

note top of NavegadorInternet
  Interface encarregada
  de implementar
  a funcionalidade 
  de um navegador.
end note

interface "Navegador de Internet" as NavegadorInternet {
  -ConexaoComInternet(): Boolean
  +exibirPagina(): void
  +adicionarNovaAba(): void
  +atualizarPagina(): void
}

entity "IPhone" as IPhone {}

entity "FireFox" as FireFox {}
entity "Chrome" as Chrome {}

entity "Nokia 3310" as Nokia3310 {}
entity "Motorola Razr V3" as MotorolaRazrV3 {}

entity "Walkman" as Walkman {}
entity "Discman" as Discman {}

IPhone --> AparelhoTelefonico
IPhone --> NavegadorInternet
IPhone --> ReprodutorMusical
ReprodutorMusical --o Musica
AparelhoTelefonico <-- Nokia3310
AparelhoTelefonico <-- MotorolaRazrV3
AparelhoTelefonico --o Contato

ReprodutorMusical <-- Walkman
ReprodutorMusical <-- Discman

NavegadorInternet <-- FireFox
NavegadorInternet <-- Chrome

@enduml