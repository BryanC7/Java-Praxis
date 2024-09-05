SELECT p.Categoría, AVG(p.Precio) AS Precio_Promedio FROM plato p
GROUP BY p.Categoría;