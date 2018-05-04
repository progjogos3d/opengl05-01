#version 330

//Matriz de transformação World
uniform mat4 uWorld;

//Matrizes de transformação da camera
uniform mat4 uView;         //Posicionamento
uniform mat4 uProjection;   //Abertura

//Atributos do vértice
in vec3 aPosition;

void main() {	
    gl_Position =  uProjection * uView * uWorld * vec4(aPosition, 1.0);        
}