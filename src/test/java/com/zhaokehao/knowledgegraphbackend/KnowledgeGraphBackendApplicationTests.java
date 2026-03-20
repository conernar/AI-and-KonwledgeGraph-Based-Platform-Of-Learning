package com.zhaokehao.knowledgegraphbackend;

import com.zhaokehao.knowledgegraphbackend.entity.User;
import com.zhaokehao.knowledgegraphbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KnowledgeGraphBackendApplicationTests {
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    /**
     * 测试数据库连接是否正常
     */
    @Test
    void testDatabaseConnection() throws SQLException {
        System.out.println("=== 开始测试数据库连接 ===");
        
        // 1. 测试数据源是否注入成功
        assertNotNull(dataSource, "数据源注入失败！");
        System.out.println("✓ 数据源注入成功");
        
        // 2. 测试能否获取数据库连接
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection, "无法获取数据库连接！");
            assertFalse(connection.isClosed(), "数据库连接已关闭！");
            
            // 输出数据库信息
            System.out.println("✓ 数据库连接成功");
            System.out.println("  数据库类型: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("  数据库版本: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("  连接URL: " + connection.getMetaData().getURL());
            System.out.println("  用户名: " + connection.getMetaData().getUserName());
        }
        
        System.out.println("=== 数据库连接测试通过 ===");
    }

    /**
     * 测试 MyBatis-Plus 是否能正常操作数据库
     */
    @Test
    void testMyBatisPlusQuery() {
        System.out.println("=== 开始测试 MyBatis-Plus 查询 ===");
        
        // 1. 测试 Mapper 是否注入成功
        assertNotNull(userMapper, "UserMapper 注入失败！");
        System.out.println("✓ UserMapper 注入成功");
        
        // 2. 测试查询所有用户（如果表不存在会报错）
        try {
            List<User> users = userMapper.selectList(null);
            assertNotNull(users, "查询结果为 null！");
            
            System.out.println("✓ MyBatis-Plus 查询成功");
            System.out.println("  查询到用户数量: " + users.size());
            
            // 如果有数据，打印第一个用户信息
            if (!users.isEmpty()) {
                User firstUser = users.get(0);
                System.out.println("  第一个用户信息: ");
                System.out.println("    用户ID: " + firstUser.getUserId());
                System.out.println("    用户名: " + firstUser.getUserName());
                System.out.println("    真实姓名: " + firstUser.getRealName());
            } else {
                System.out.println("  提示: 数据库中暂无用户数据");
            }
        } catch (Exception e) {
            fail("MyBatis-Plus 查询失败: " + e.getMessage());
        }
        
        System.out.println("=== MyBatis-Plus 查询测试通过 ===");
    }

    /**
     * 测试根据ID查询用户
     */
    @Test
    void testSelectById() {
        System.out.println("=== 开始测试根据ID查询用户 ===");
        
        // 先查询所有用户，如果有数据则测试根据ID查询
        List<User> users = userMapper.selectList(null);
        
        if (!users.isEmpty()) {
            Long userId = users.get(0).getUserId();
            User user = userMapper.selectById(userId);
            
            assertNotNull(user, "根据ID查询用户失败！");
            assertEquals(userId, user.getUserId(), "查询到的用户ID不匹配！");
            
            System.out.println("✓ 根据ID查询成功");
            System.out.println("  用户ID: " + user.getUserId());
            System.out.println("  用户名: " + user.getUserName());
        } else {
            System.out.println("⚠ 数据库中暂无用户数据，跳过此测试");
        }
        
        System.out.println("=== 根据ID查询测试完成 ===");
    }

    /**
     * 测试数据库表是否存在
     */
    @Test
    void testTableExists() throws SQLException {
        System.out.println("=== 开始测试数据库表是否存在 ===");
        
        try (Connection connection = dataSource.getConnection()) {
            var metaData = connection.getMetaData();
            var tables = metaData.getTables(null, null, "sys_user", null);
            
            boolean tableExists = tables.next();
            assertTrue(tableExists, "sys_user 表不存在！请先创建数据库表。");
            
            System.out.println("✓ sys_user 表存在");
            
            // 获取表的列信息
            var columns = metaData.getColumns(null, null, "sys_user", null);
            System.out.println("  表结构:");
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                System.out.println("    - " + columnName + " (" + columnType + ")");
            }
        }
        
        System.out.println("=== 数据库表测试通过 ===");
    }

}
