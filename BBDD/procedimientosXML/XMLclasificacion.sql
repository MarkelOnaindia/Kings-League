/*Kings League equipo 2*/
/*PL/SQL para crear el xml de clasificacion*/

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'SELECT * FROM clasificacion');
			  
  -- Set the name of the document root element. The default name is ROWSET			  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Clasificaciones');
  
  -- Set the row header to be EMPLOYEE
  DBMS_XMLGEN.setRowTag(qryCtx, 'Clasificacion');
  
  --Poner nulos
  DBMS_XMLGEN.SETNULLHANDLING(qryCtx, 2);
  
  -- Get the result
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO CAL_XML_RESULTADO VALUES(DEFAULT, result, 'Clasificacion');
  
  --Close context
  DBMS_XMLGEN.closeContext(qryCtx);
END;

