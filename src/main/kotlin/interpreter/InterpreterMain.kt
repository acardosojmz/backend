package interpreter

import interpreter.nonterminals.*
import interpreter.terminals.DateExpression
import interpreter.terminals.LiteralExpression
import interpreter.terminals.NumericExpression
import interpreter.terminals.TextExpression


class InterpreterMain {
    companion object{
        fun getById(): SelectExpression? {
            return SelectExpression(
                TargetExpression(
                    LiteralExpression("FIRST_NAME"),
                    LiteralExpression("LAST_NAME")
                ),
                FromExpression(
                    LiteralExpression("EMPLOYEES")
                ),
                WhereExpression(
                    BooleanExpression(
                        LiteralExpression("ID"),
                        LiteralExpression("="),
                        NumericExpression(10)
                    )
                )
            )
        }
    }

    fun findByDate(): SelectExpression? {
        return SelectExpression(
            TargetExpression(
                LiteralExpression("ID"),
                LiteralExpression("BORN_DATE"),
                LiteralExpression("DEPARTMENT"),
                LiteralExpression("FIRST_NAME"),
                LiteralExpression("LAST_NAME")
            ),
            FromExpression(
                LiteralExpression("EMPLOYEES")
            ),
            WhereExpression(
                BooleanExpression(
                    LiteralExpression("BORN_DATE"),
                    LiteralExpression(">"),
                    DateExpression("01/01/1990")
                )
            )
        )
    }
    fun findByTwoID(): SelectExpression? {
        return SelectExpression(
            TargetExpression(
                LiteralExpression("FIRST_NAME"),
                LiteralExpression("DEPARTMENT"),
                LiteralExpression("ID")
            ),
            FromExpression(
                LiteralExpression("EMPLOYEES")
            ),
            WhereExpression(
                OrExpression(
                    BooleanExpression(
                        LiteralExpression("ID"),
                        LiteralExpression("="),
                        NumericExpression(5)
                    ),
                    BooleanExpression(
                        LiteralExpression("ID"),
                        LiteralExpression("="),
                        NumericExpression(14)
                    )
                )
            )
        )
    }

    fun complexQuery(): SelectExpression? {
        return SelectExpression(
            TargetExpression(
                LiteralExpression("FIRST_NAME"),
                LiteralExpression("LAST_NAME")
            ),
            FromExpression(
                LiteralExpression("EMPLOYEES")
            ),
            WhereExpression(
                AndExpression(
                    BooleanExpression(
                        LiteralExpression("STATUS"),
                        LiteralExpression("="),
                        TextExpression("Activo")
                    ),
                    AndExpression(
                        BooleanExpression(
                            LiteralExpression("BORN_DATE"),
                            LiteralExpression("<="),
                            DateExpression("01/01/1981")
                        ),
                        OrExpression(
                            BooleanExpression(
                                LiteralExpression("DEPARTMENT"),
                                LiteralExpression("="),
                                TextExpression("Sistemas")
                            ),
                            BooleanExpression(
                                LiteralExpression("DEPARTMENT"),
                                LiteralExpression("="),
                                TextExpression("Contabilidad")
                            )
                        )
                    )
                )
            )
        )
    }


}