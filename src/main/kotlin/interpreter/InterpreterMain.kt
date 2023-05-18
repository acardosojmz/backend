package interpreter

import interpreter.nonterminals.*
import interpreter.terminals.DateExpression
import interpreter.terminals.LiteralExpression
import interpreter.terminals.NumericExpression
import interpreter.terminals.TextExpression


class InterpreterMain {
    companion object {
        fun getById(id: Int): SelectExpression? {
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
                        NumericExpression(id)
                    )
                )
            )
        }

        fun findByDate(date: String): SelectExpression? {
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
                        DateExpression(date)
                    )
                )
            )
        }

        fun findByTwoID(ids:Array<Int>): SelectExpression? {
            return SelectExpression(
                TargetExpression(
                    LiteralExpression("ID"),
                    LiteralExpression("FIRST_NAME"),
                    LiteralExpression("DEPARTMENT"),

                ),
                FromExpression(
                    LiteralExpression("EMPLOYEES")
                ),
                WhereExpression(
                    OrExpression(
                        BooleanExpression(
                            LiteralExpression("ID"),
                            LiteralExpression("="),
                            NumericExpression(ids[0])
                        ),
                        BooleanExpression(
                            LiteralExpression("ID"),
                            LiteralExpression("="),
                            NumericExpression(ids[1])
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
                                LiteralExpression(">="),
                                DateExpression("01/01/1981")
                            ),
                            OrExpression(
                                BooleanExpression(
                                    LiteralExpression("DEPARTMENT"),
                                    LiteralExpression("="),
                                    TextExpression("Develop")
                                ),
                                BooleanExpression(
                                    LiteralExpression("DEPARTMENT"),
                                    LiteralExpression("="),
                                    TextExpression("Teacher")
                                )
                            )
                        )
                    )
                )
            )
        }

    }
}