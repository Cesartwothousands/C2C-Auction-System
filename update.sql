delimiter //
CREATE PROCEDURE ROWPERROW()
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE n INT DEFAULT 0;
    SET i = 1;
    SET n = 20;
    WHILE i <= n DO
            UPDATE mydb.auction SET auction.currentPrice =
                                        (SELECT max(price) FROM mydb.bid
                                         WHERE mydb.bid.idItem = i
                                         GROUP BY idItem)
            WHERE mydb.auction.idItem = i;
            SET i = i + 1;
        END WHILE;
End;
;;

CALL ROWPERROW();