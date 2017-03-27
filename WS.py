from flask import Flask
from flask import request
from flask import render_template
from matriz import Matriz

app = Flask(__name__)

matriz=Matriz()

class WS():


# MATRIZ
	# AGREGAR VALOR
	@app.route('/agregar_usuario',methods=['POST'])
	def agregar():
		Usuario   = request.form['usuario']
		Contrasena= request.form['contrasena']
		Nombre    = request.form['nombre']
		Empresa	=request.form['empresa']
		Departamento=request.form['departamento']
		return matriz.agregar(Usuario,Contrasena,Nombre,Empresa,Departamento)

	@app.route('/login',methods=['POST'])
	def login():
		Usuario   = request.form['user']
		Contrasena= request.form['pass']
		Empresa	=request.form['fact']
		Departamento=request.form['dept']
		return matriz.sesion(Empresa,Departamento,Usuario,Contrasena)

	@app.route('/plotear',methods=['POST'])
	def plotearMatriz():
		return matriz.graficar_Mat()

	@app.route('/lista_empresas',methods=['POST'])
	def lista_empresas():
		return matriz.retornarEmpresas()
	# CONSULTAR POR LETRA
	@app.route('/lista_deartamentos',methods=['POST'])
	def lista_deartamentos():
		Empresa   = request.form['empresa']
		return matriz.retornarDeptosDeEmpresa(Empresa)

	@app.route('/lista_usuarios',methods=['POST'])
	def lista_usuarios():
		Empresa   = request.form['empresa']
		Departamento   = request.form['departamento']
		return matriz.retornarUsuarios(Empresa,Departamento)

	@app.route('/arbol',methods=['POST'])
	def arbol():
		Empresa   = request.form['empresa']
		Departamento   = request.form['departamento']
		Usuario = request.form['usuario']
		return matriz.retornarID_arbol(Empresa,Departamento,Usuario)


# INDEX
	@app.route('/')
	def index():
		return "<html><head><body>dale rifresh :0</body></head></html>"


	if __name__=='__main__':
		app.run(debug=True)

