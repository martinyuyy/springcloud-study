package com.martin.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.base.Converter;
import com.martin.common.base.BaseEntity;
import com.martin.pojo.dto.CategoryDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Martin-yuyy
 * @since 2019-04-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String name;

    /**
     * 内容描述
     */
    private String content;

    private String summary;

    /**
     * 图标
     */
    private String icon;

    /**
     * 该分类的内容数量
     */
    private Integer postCount;

    /**
     * 排序编码
     */
    private Integer orderNum;

    /**
     * 父级分类的ID
     */
    private Long parentId;

    /**
     * SEO关键字
     */
    private String metaKeywords;

    /**
     * SEO描述内容
     */
    private String metaDescription;

    public CategoryDTO converToCategoryDTO(Category category){
        CategoryDTOConver categoryDTOConver = new CategoryDTOConver();
        return categoryDTOConver.doForward(category);
    }

    private static class CategoryDTOConver extends Converter<Category, CategoryDTO> {

        @Override
        protected CategoryDTO doForward(Category category) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtil.copyProperties(category, categoryDTO);
            return categoryDTO;
        }

        @Override
        protected Category doBackward(CategoryDTO categoryDTO) {
            Category category = new Category();
            BeanUtil.copyProperties(categoryDTO, category);
            return category;
        }
    }
}
