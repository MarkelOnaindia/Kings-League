/*Kings League equipo 2*/
/*PL/SQL para crear el xml de clasificacion*/

CREATE OR REPLACE PROCEDURE generar_xml_clasificacion AS
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
  fecha_expiracion VARCHAR2(20);
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'SELECT * FROM clasificacion');
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Clasificacion');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'Equipo');
  
  -- Poner nulos
  DBMS_XMLGEN.SETNULLHANDLING(qryCtx, 2);
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  
  -- Calculate expiration date
  fecha_expiracion := TO_DATE(SYSDATE + 7, 'DD-MM-YYYY');
  
  -- Insert into CAL_XML_RESULTADO table
  INSERT INTO CAL_XML_RESULTADOS VALUES(DEFAULT, result, fecha_expiracion, 'Clasificacion');
  
  -- Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;