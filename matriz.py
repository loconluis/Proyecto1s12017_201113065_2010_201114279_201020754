from avl import AVL

class NodoMatriz():
	def __init__(self):
		self.usuario=None
		self.contrasena = None
		self.nombre=None
		self.empresa=None
		self.departamento=None
		self.arbol=None
		self.arriba=None
		self.abajo=None
		self.izquierda=None
		self.derecha=None
		self.entra=None
		self.sale=None

class Matriz():
	def __init__(self):
		self.raiz=None
		self.departamento=None
		self.empresa=None

	def agregar(self,Usuario,Contrasena,Nombre,Empresa,Departamento):
	# agregar datos a la matriz
		DEPTO = NodoMatriz()
		DEPTO.Departamento=Departamento
		EMPRESA=NodoMatriz()
		EMPRESA.empresa=Empresa
		INFO=NodoMatriz()
		INFO.usuario=Usuario
		INFO.contrasena=Contrasena
		INFO.nombre=Nombre
		INFO.empresa=Empresa
		INFO.departamento=Departamento
		if self.raiz==None:
			
			self.raiz=NodoMatriz()
			
			self.raiz.derecha=EMPRESA
			EMPRESA.izquierda=self.raiz
			EMPRESA.abajo=INFO
			INFO.arriba=EMPRESA
			
			DEPTO.arriba=self.raiz
			self.raiz.abajo=DEPTO
			DEPTO.derecha=INFO
			INFO.izquierda=DEPTO
			return "No exitian datos, Matriz creada"

		else:
			puntero=self.raiz
			empresa=self.raiz.derecha
			departamento= self.raiz.abajo
			temporal=self.raiz.abajo
			while departamento!=None:
				if departamento.departamento==Departamento:
				# existe el departamento...empresaaa?
					departamento=departamento.derecha
					while departamento!=None:
						if departamento.empresa==Empresa:
						# existe el departamento YYYY la empresa	
							if departamento.usuario==Usuario:
								return "Este usuario ya existe para esta empresa "
							else:
								while departamento.entra!=None:
									if departamento.usuario==Usuario:
										return "Este usuario ya existe para esta empresa"
									departamento=departamento.entra
								departamento.entra=INFO
								INFO.sale=departamento
								return "la empresa y el departamento existian, "+Usuario+" agregado"
						puntero=departamento
						departamento=abajo.derecha
						return
					#existe el departamento, pero NO la empresa
					puntero.derecha=INFO
					INFO.izquierda=puntero
					while derecha.derecha!=None:
						derecha=derecha.derecha
					derecha.derecha=DEPTO
					DEPTO.izquierda=derecha
					DEPTO.abajo=INFO
					INFO.arriba=DEPTO
					return "el departamento exisitia, empresa nueva creada y "+Usuario+" agregado"
				temporal=departamento
				departamento=departamento.abajo

			# quiere decir que no encontro el departamento, a crearlo

			temporal.abajo=DEPTO
			DEPTO.arriba=temporal
			DEPTO.derecha=INFO
			INFO.izquierda=DEPTO
			# a buscar si exite entonces la empresa, pero NO el depto
			temporal=empresa
			while empresa!=None:
				if empresa.empresa==Empresa:
					# SI EXISTE LA EMPRESA
					while empresa!=None:
						temporal=empresa
						empresa=empresa.abajo
					temporal.abajo=INFO
					INFO.arriba=temporal
					return "empresa agregada y el usuario"
				temporal=empresa
				empresa=empresa.derecha
			# la empresa no existe tampoco, COMO VA A SER ESO :O, pues... a crearlo
			temporal.derecha=EMPRESA
			EMPRESA.izquierda=temporal
			EMPRESA.abajo=INFO
			INFO.arriba=EMPRESA
			return "cargada la empresa y el departamento y el usuario"

	def sesion(self,empresa,departamento,usuario,contrasena):
	#determinar si la sesion esta abierta, guardar datos en cookies para uso posterior 
		if self.raiz!=None:
			temporal=self.raiz.derecha
			while temporal!=None:
				if temporal.empresa==empresa:
					temporal=temporal.abajo
					while temporal!=None:
						if temporal.departamento==departamento:
							if temporal.usuario==usuario and temporal.contrasena==contrasena:
								return "1"
							else:
								return "0"
						temporal=temporal.abajo
					return "0"
				temporal=temporal.derecha
		else:
			return "0"

	def graficar_Mat(self):
	# Grafica la matriz completa
		retorno="digraph g{"
		if self.raiz!=None:
			empresa = self.raiz.derecha
			valY=1
			while empresa!=None:
				valX=1
				baja=empresa
				retorno=retorno+"\n\""+baja.empresa+"\"->\""+baja.abajo.usuario+"_("+valX+","+valY+")\";"
				retorno=retorno+"\n\""+baja.abajo.usuario+"_("+valX+","+valY+")\"->\""+baja.empresa+"\";"
				baja=baja.abajo
				last_depto=None
				val=True
				while baja!=None:
					if val==True:
						val=False
					else:
						retorno=retorno+"\n\""+baja.arriba.usuario+"_("+(valX-1)+","+valY+")\"->\""+baja.usuario+"_("+valX+","+valY+")\";"
						retorno=retorno+"\n\""+baja.usuario+"_("+valX+","+valY+")\"->\""+baja.arriba.usuario+"_("+(valX-1)+","+valY+")\";"

					if baja.izquierda.izquierda==None:
						retorno=retorno+"\n\""+baja.izquierda.departamento+"\"->\""+baja.usuario+"_("+valX+","+valY+")\";"
						retorno=retorno+"\n\""+baja.usuario+"_("+valX+","+valY+")\"->\""+baja.izquierda.departamento+"\";"
						if last_depto!=None:
							retorno=retorno+"\n\""+baja.izquierda.departamento+"\"->\""+last_depto.departamento+"\";"
							retorno=retorno+"\n\""+last_depto.departamento+"\"->\""+baja.izquierda.departamento+"\";"
						last_depto=baja.izquierda
						
					else:
						retorno=retorno+"\n\""+baja.izquierda.usuario+"_("+valX+","+(valY-1)+")\"->\""+baja.usuario+"_("+valX+","+valY+")\";"
						retorno=retorno+"\n\""+baja.usuario+"_("+valX+","+valY+")\"->\""+baja.izquierda.usuario+"_("+valX+","+(valY-1)+")\";"
					if baja.entra!=None:
						tmp=baja.entra
						while tmp!=None:
							retorno=retorno+"\n\""+tmp.sale.usuario+"_("+valX+","+valY+")\"->\""+tmp.usuario+"_("+valX+","+valY+")\";"
							retorno=retorno+"\n\""+tmp.usuario+"_("+valX+","+valY+")\"->\""+tmp.sale.usuario+"_("+valX+","+valY+")\";"
							tmp=tmp.entra

					valX=valX+1
					baja=baja.abajo
				empresa=empresa.derecha
				valY=valY+1
				if empresa!=None:
					retorno=retorno+"\n\""+empresa.empresa+"\"->\""+empresa.izquierda.empresa+"\";"
					retorno=retorno+"\n\""+empresa.izquierda.empresa+"\"->\""+empresa.empresa+"\";"

		return retorno+"\n}"
	def retornarEmpresas(self):
	#retorna todas las empresa, separados por el simbolo "~"
		if self.raiz!=None:
			retorno=""
			sig = self.raiz.derecha
			while sig!=None:
				if retorno=="":
					retorno=sig.empresa
				else:
					retorno=retorno+"~"+sig.empresa
				sig=sig.derecha
			return retorno
		else:
			return None
	def retornarDeptosDeEmpresa(self,empresa):
	#retorna todos departamentos DE la empresa, separados por el simbolo "~"
		empresa=self.raiz.derecha
		while empresa!=None:
			if empresa.empresa==empresa:
				empresa=empresa.abajo
				retorno=""
				while empresa!=None:
					if retorno=="":
						retorno=empresa.departamento
					else:
						retorno=retorno+"~"+empresa.departamento
					empresa=empresa.abajo
				return retorno
			empresa=empresa.derecha
		return None

	def retornarUsuarios(self,empresa,departamento):
	# retornar los usuarios que tiene esa empresa en ESE departamento
		if raiz!=None:
			arbol=raiz.derecha
			while arbol!=None:
				if arbol.empresa==empresa:
					arbol=arbol.abajo
					while arbol!=None:
						if arbol.departamento==departamento:
							retorno =arbol.usuario
							arbol=arbol.entra
							while arbol!=None:
								retorno=retorno+"~"+arbol.usuario
								arbol=arbol.entra
							return retorno
						arbol=arbol.abajo
				arbol=arbol.derecha
		return None


	def retornarID_arbol(self,empresa,departamento,usuario):
	#retornar la lista de ID's que tiene el arbol 
		if raiz!=None:
			arbol=raiz.derecha
			while arbol!=None:
				if arbol.empresa==empresa:
					arbol=arbol.abajo
					while arbol!=None:
						if arbol.departamento==departamento:
							retorno =arbol.usuario
							arbol=arbol.entra
							while arbol!=None:
								retorno=retorno+"~"+arbol.usuario
								arbol=arbol.entra
							return retorno
						arbol=arbol.abajo
				arbol=arbol.derecha
		return None

	def agregarBien(self,empresa,departamento,usuario,id,nombre,descripcion):
	# agregar bien en un arbol AVL
		nodoAVL=avl()
		nodoAVL.id=id
		nodoAVL.nombre=nombre
		nodoAVL.descripcion=descripcion
		if self.raiz!=None:
			arbol=self.raiz.derecha
			while arbol!=None:
				if arbol.empresa==empresa:
					arbol=arbol.abajo
					while arbol!=None:
						if arbol.departamento==departamento:
							while arbol!=None:
								if arbol.usuario==usuario:
									if arbol.arbol==None:
										arbol.arbol=nodoAVL
									else:
										arbol.arbol.cargar(id,nombre,descripcion)
								arbol=arbol.entra
							retorno =arbol.usuario
							arbol=arbol.entra
							while arbol!=None:
								retorno=retorno+"~"+arbol.usuario
								arbol=arbol.entra
							return "No se encontro el usuario"
						arbol=arbol.abajo
					return "No se encontro el departamento"
				arbol=arbol.derecha
			return "No se encontro la empresa"
		return "la matriz esta vacia"






