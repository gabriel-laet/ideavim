package com.maddyhome.idea.vim.group;

/*
 * IdeaVim - A Vim emulator plugin for IntelliJ Idea
 * Copyright (C) 2003 Rick Maddy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import com.intellij.openapi.diagnostic.Logger;
import org.jdom.Element;

/**
 * This singleton maintains the instances of all the key groups. All the key/action mappings get created the first
 * this singleton is accessed.
 */
public class CommandGroups
{
    /**
     * Gets the singleton instance
     * @return The singleton instance
     */
    public static CommandGroups getInstance()
    {
        if (instance == null)
        {
            instance = new CommandGroups();
        }
        
        return instance;
    }

    /**
     * Creates all the groups
     */
    private CommandGroups()
    {
        motion = new MotionGroup();
        change = new ChangeGroup();
        copy = new CopyGroup();
        mark = new MarkGroup();
        register = new RegisterGroup();
        file = new FileGroup();
    }

    /**
     * Returns the motion group
     * @return The motion group
     */
    public MotionGroup getMotion()
    {
        return motion;
    }

    /**
     * Returns the change group
     * @return The change group
     */
    public ChangeGroup getChange()
    {
        return change;
    }

    /**
     * Returns the copy group
     * @return The copy group
     */
    public CopyGroup getCopy()
    {
        return copy;
    }

    /**
     * Returns the mark group
     * @return The mark group
     */
    public MarkGroup getMark()
    {
        return mark;
    }

    /**
     * Returns the register group
     * @return The register group
     */
    public RegisterGroup getRegister()
    {
        return register;
    }

    /**
     * Returns the file group
     * @return The file group
     */
    public FileGroup getFile()
    {
        return file;
    }

    /**
     * Tells each group to save its data.
     * @param element The plugin's root element
     */
    public void saveData(Element element)
    {
        motion.saveData(element);
        change.saveData(element);
        copy.saveData(element);
        mark.saveData(element);
        register.saveData(element);
        file.saveData(element);
    }

    /**
     * Tells each group to read its data.
     * @param element The plugin's root element
     */
    public void readData(Element element)
    {
        logger.debug("readData");
        motion.readData(element);
        change.readData(element);
        copy.readData(element);
        mark.readData(element);
        register.readData(element);
        file.readData(element);
    }

    private static CommandGroups instance;
    private MotionGroup motion;
    private ChangeGroup change;
    private CopyGroup copy;
    private MarkGroup mark;
    private RegisterGroup register;
    private FileGroup file;

    private static Logger logger = Logger.getInstance(CommandGroups.class.getName());
}