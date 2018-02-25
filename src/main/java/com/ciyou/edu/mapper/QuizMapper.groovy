package com.ciyou.edu.mapper

import com.ciyou.edu.entity.Quiz
import com.github.pagehelper.Page
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.One
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

/**
 * @Author C.
 * @Date 2018-02-24 23:23
 */
interface QuizMapper {
    @Select("select * from Quiz")
    @Results([
            //查询关联对象
            @Result(property = "grade",
                    column = "gradeId",
                    one = @One(select = "com.ciyou.edu.mapper.GradeMapper.getGrade")),
            @Result(property = "subject",
                    column = "subjectId",
                    one = @One(select = "com.ciyou.edu.mapper.SubjectMapper.getSubject"))
    ])
    Page<Quiz> findAllQuiz()

    @Insert("Insert into Quiz(quizName,subjectId,gradeId,quizTime,choiceScore,judgeScore) values(#{quizName},#{subject.subjectId},#{grade.gradeId},#{quizTime},#{choiceScore},#{judgeScore})")
    int addQuiz(Quiz quiz)
}
