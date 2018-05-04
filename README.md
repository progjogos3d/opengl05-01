# Aula 05 - Iluminação

O projeto contém dois shaders chamados phong.vert e phong.frag. Esses shaders são basicamente uma cópia dos shaders 
básicos sem cor da aula passada. Na classe MeshFactory, o cubo é criado apenas com a posição e índices.

Ao rodar esse projeto, uma tela completamente preta deve aparecer. Isso acontece pois o nosso fragment shader ainda
retorna somente a cor preta, já que nada está iluminado.

Iremos aprender como implementar o modelo de iluminação de Phong. Trata-se de um **modelo de iluminação local**, ou seja, 
calcularemos a iluminação de cada objeto individualmente, sem levar em conta outros objetos da cena. Neste modelo a luz 
é dividida em tres componentes:
* Ambiente: Trata-se da porção de luz que já se espalhou tanto, que não tem mais origem definida. Seria aquela luz da 
penumbra, quando todas as luzes estão apagadas, mas sobra um pouco de iluminação que não conseguimos definir de onde 
vem.
* Difuso: Trata-se da iluminação invade o ambiente com uma direção definida, mas é absorvida pelo objeto, sem gerar 
reflexo.
* Especular: É a porção da iluminação que choca contra os objetos e geram reflexo, atingindo o olho do observador. 
Aparece na forma de um brilho sobre a malha.

É importante observar que o modelo de Phong é uma simplificação grosseira, e não se trata de um modelo fiel a física. 
Ele é focado num resultado visual consistente com baixo custo computacional, não em realizar uma simulação perfeita da 
luz.  
