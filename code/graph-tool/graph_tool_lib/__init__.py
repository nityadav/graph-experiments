import graph_tool.all as gt

# class for wrapping up basic graph object from graph_tool
# coregraph: the graph object from the graph_tool library
# if_directed: True if the graph is directed, False otherwise

class graph:

	def __init__(self, if_directed=False):
		self.coregraph = gt.Graph(directed=if_directed)

	# load from graph_tool data
	def load_from_graphtool(self, name):
		self.coregraph = gt.collection.data[name]