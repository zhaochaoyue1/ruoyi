package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Student;

/**
 * studentService接口
 * 
 * @author ruoyi
 * @date 2021-04-23
 */
public interface IStudentService 
{
    /**
     * 查询student
     * 
     * @param id studentID
     * @return student
     */
    public Student selectStudentById(Long id);

    /**
     * 查询student列表
     * 
     * @param student student
     * @return student集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增student
     * 
     * @param student student
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改student
     * 
     * @param student student
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除student
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentByIds(String ids);

    /**
     * 删除student信息
     * 
     * @param id studentID
     * @return 结果
     */
    public int deleteStudentById(Long id);
}
