class NodoAVL():
	def __init__(self):
		self.id=None
		self.nombre=None
		self.descripcion=None
		self.derecho=None
		self.izquierdo=None
		self.FE=0

class AVL(object):
	def __init__(self):
		self.raiz=None

	def buscar(self,dato,Nodo,valor):
		if self.raiz!=None:
			if Nodo.id==dato:
				return dato
			else:
				menor=-1
				while True:
					#si el valor buscado es menor al valor en el nodo:
					if ord(dato[valor])<ord(Nodo.id[valor]):
						return buscar(dato,Nodo.izquierdo,0)
						break
					if ord(dato[valor])>ord(Nodo.id[valor]):
						return buscar(dato,Nodo.derecho,0)	
						break
					valor=valor+1
					if valor==len(dato):
						menor=0
						break
		return None

	def obtenerFE(self, Nodo):
		if Nodo==None:
			return -1
		else:
			return Nodo.FE

	def rotarIzq(self, Nodo):
		aux = Nodo.izquierdo
		Nodo.izquierdo=aux.derecho
		aux.derecho=Nodo
		Nodo.FE=max( obtenerFE(Nodo.izquierdo), obtenerFE(Nodo.derecho))+1
		aux.FE=max( obtenerFE(Nodo.izquierdo), obtenerFE(Nodo.derecho))+1
		return aux

	def rotarDer(self,Nodo):
		aux = Nodo.derecho
		Nodo.derecho=aux.izquierdo
		aux.izquierdo=Nodo
		Nodo.FE=max( obtenerFE(Nodo.izquierdo), obtenerFE(Nodo.derecho))+1
		aux.FE=max( obtenerFE(Nodo.izquierdo), obtenerFE(Nodo.derecho))+1
		return aux

	def rotarDobleIzq(self,Nodo):
		Nodo.izquierdo=rotarDer(Nodo.izquierdo)
		temp = rotarIzq(Nodo)
		return temp

	def rotarDobleDer(self,Nodo):
		Nodo.derecho=rotarIzq(Nodo.derecho)
		temp=rotarDer(Nodo)
		return temp

	def insertar(self,Nuevo,subAr):
		NuevoPadre=subAr
		valor=0
		while True:
			if ord(Nuevo.id[valor])<ord(Nodo.id[valor]):
				if subAr.izquierdo==None:
					subAr.izquierdo=Nuevo
				else:
					subAr.izquierdo=insertar(Nuevo,subAr.izquierdo)
					if (obtenerFE(subAr.izquierdo)-obtenerFE(subAr.derecho))==2:
						counter=0
						while True:
							if ord(Nuevo.id[counter])<ord(subAr.izquierdo.id[counter]):
								NuevoPadre=rotarIzq(subAr)
								break
							counter=counter+1
							if counter==len(Nuevo.id):
								NuevoPadre=rotarDobleIzq(subAr)
								break

			elif ord(dato[valor])>ord(Nodo.id[valor]):
				if subAr.derecho==None:
					subAr.derecho=Nuevo
				else:
					subAr.derecho=insertar(Nuevo,subAr.derecho)
					if (obtenerFE(subAr.derecho)-obtenerFE(subAr.izquierdo))==2:
						counter=0
						while True:
							if ord(Nuevo.id[counter])>ord(subAr.derecho.id[counter]):
								NuevoPadre=rotarDer(subAr)
								break
							counter=counter+1
							if counter==len(Nuevo.id):
								NuevoPadre=rotarDobleDer(subAr)
								break

			valor=valor+1
			if valor==len(Nuevo.id[valor]):
				print "nodo duplicado... que pepas :O"
				break
		if subAr.izquierdo==None and subAr.derecho!=None:
			subAr.FE=subAr.derecho.FE+1
		elif subAr.derecho==None and subAr.izquierdo!=None:
			subAr.FE=subAr.izquierdo.FE+1
		else:
			subAr.FE=max(obtenerFE(subAr.izquierdo),obtenerFE(subAr.derecho))+1
		return NuevoPadre

	def cargar(self,id,nombre,descripcion):
		Nuevo=NodoAVL()
		Nuevo.id=id
		Nuevo.nombre=nombre
		Nuevo.descripcion=descripcion
		if self.raiz==None:
			self.raiz=Nuevo
		else:
			raiz=insertar(Nuevo,raiz)


		
