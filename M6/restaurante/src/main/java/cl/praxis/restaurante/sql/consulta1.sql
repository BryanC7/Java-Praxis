SELECT p.ID, c.Nombre AS camarero, m.Numero AS numero_mesa, p.Total FROM camarero c
INNER JOIN pedido p on c.ID = p.Camarero_ID
INNER JOIN mesa m on p.Mesa_ID = m.ID;