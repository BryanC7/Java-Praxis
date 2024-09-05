SELECT c.Nombre, SUM(p.Total) AS Ventas_Totales FROM camarero c
INNER JOIN pedido p on c.ID = p.Camarero_ID
GROUP BY c.Nombre
ORDER BY Ventas_Totales;